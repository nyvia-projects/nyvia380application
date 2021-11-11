package com.project.nyvia380server.common.user;

import com.project.nyvia380server.util.Utils;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Log4j2
@Validated
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final Utils utils;

    private final ModelMapper modelMapper;

    /*@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }*/

    private UserMetaData convertToDTO(Member member) {
        return modelMapper.map(member, UserMetaData.UserMetaDataBuilder.class)
                .build();
    }

    private Member convertToEntity(UserMetaData dto) {
        return modelMapper.map(dto, Member.MemberBuilder.class)
                .build();
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
    public ResponseEntity<UserMetaData> getUser(@PathVariable UUID id) {
        return ResponseEntity.ok(convertToDTO(userService.getUser(id)));
    }

    @PutMapping("/insertUser")
    public ResponseEntity<UserMetaData> insertUser(@Payload @Valid UserMetaData dto) {
        return ResponseEntity.ok(convertToDTO(userService.insertUser(convertToEntity(dto))));
    }

    @PutMapping("/insertUser")
    public ResponseEntity<Member> insertUser(@RequestBody @Valid Member member) {
        return ResponseEntity.ok(userService.insertUser(member));
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
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
