package com.project.nyvia380server.common.user;

import com.project.nyvia380server.util.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Log4j2
@Validated
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final Utils utils;

    private final UserService userService;

    /*@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }*/

    @GetMapping("/message")
    public String getMessage() {
        return userService.getMessage();
    }


    @GetMapping("/all")
    public ResponseEntity<List<Member>> getUsers() {
        log.info("Date Formatted: {}", utils.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/findUser/{id}")
    public ResponseEntity<Member> getUser(@PathVariable UUID id) {
        return ResponseEntity.of(userService.getUser(id));
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
