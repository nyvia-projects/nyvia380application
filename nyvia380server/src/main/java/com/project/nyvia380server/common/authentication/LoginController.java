package com.project.nyvia380server.common.authentication;

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

//  @Autowired
    private final UserController userController;

    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody UserMetaData member) {

        try {
            UserMetaData user = userController.findUserByAlias(member.getAlias());
            if (user.getPassword().equals(member.getPassword()))
                // User exist and password correct
                return ResponseEntity.ok(user);
            else
                // Password incorrect
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } catch (ResourceNotFoundException e) {
            // No user with alias in db
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}