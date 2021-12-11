package com.project.nyvia380server.common.authentication;


import com.project.nyvia380server.common.user.UserController;
import com.project.nyvia380server.common.user.UserMetaData;
import com.project.nyvia380server.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class RegisterController {

//  @Autowired
    private final UserController userController;

    @PostMapping("/register")
    public ResponseEntity<UserMetaData> userRegister (@RequestBody UserMetaData member) {
        try {
            userController.findUserByAlias(member.getAlias());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (ResourceNotFoundException exception) {
            return ResponseEntity.ok(userController.insertUser(member));
        }

    }

}
