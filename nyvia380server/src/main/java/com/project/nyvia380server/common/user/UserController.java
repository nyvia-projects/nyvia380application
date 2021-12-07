package com.project.nyvia380server.common.user;

import com.project.nyvia380server.util.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Log4j2
@Validated
@CrossOrigin
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final Utils utils;

    private final ModelMapper modelMapper;
    
    private UserMetaData convertToDTO(Member member) {
        return modelMapper.map(member, UserMetaData.UserMetaDataBuilder.class)
                .build();
    }

    private Member convertToEntity(UserMetaData dto) {
        return modelMapper.map(dto, Member.class);
    }

    @GetMapping("/toEntity")
    public Member toEntity(@RequestBody @Valid UserMetaData dto) {
        return convertToEntity(dto);
    }
    @GetMapping("/toDTO")
    public UserMetaData toEntity(@RequestBody @Valid Member dto) {
        return convertToDTO(dto);
    }


    @GetMapping("/message")
    public String getMessage() {
        return userService.getMessage();
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserMetaData>> getUsers() {
        log.info("Date Formatted: {}", utils.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(userService.getUsers()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList()));
    }

    @GetMapping("/findUser/{id}")
    public ResponseEntity<UserMetaData> getUser(@PathVariable String id) {
        return ResponseEntity.ok(convertToDTO(userService.getUser(id)));
    }

    @GetMapping("/findUserByAlias/{alias}")
    public ResponseEntity<UserMetaData> findUserByAlias(@PathVariable String alias) {
        return ResponseEntity.ok(convertToDTO(userService.findUserByAlias(alias)));
    }

    @PutMapping("/insertUser")
    public UserMetaData insertUser(@RequestBody @Valid UserMetaData dto) {
        return convertToDTO(userService.insertUser(convertToEntity(dto)));
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/updateUser")
    public ResponseEntity<Void> updateUser(@RequestBody @Valid Member member) {
        userService.updateUser(member);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getUserCount() {
        return ResponseEntity.ok(userService.getUserCount());
    }


}
