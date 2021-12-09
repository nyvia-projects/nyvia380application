package com.project.nyvia380server.common.Authorization;

import com.project.nyvia380server.common.user.UserController;
import com.project.nyvia380server.common.user.UserMetaData;
import com.project.nyvia380server.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class LoginController {
    @Autowired
    private UserController userController;

    @PostMapping("/login")
    public ResponseEntity<?> userLogin (@RequestBody UserMetaData member) {
        UserMetaData user = validateUser(member);

        if (user.getFirstName() != "null") {
            return ResponseEntity.ok(user);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public UserMetaData validateUser (UserMetaData user) {

        try {
            return userController.findUserByAlias(user.getAlias());
        } catch (ResourceNotFoundException e) {
            return user;
        }
    }
}
