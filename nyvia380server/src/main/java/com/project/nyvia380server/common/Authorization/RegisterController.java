package com.project.nyvia380server.common.Authorization;


import com.project.nyvia380server.common.user.Member;
import com.project.nyvia380server.common.user.UserController;
import com.project.nyvia380server.common.user.UserMetaData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequiredArgsConstructor
public class RegisterController {

    /*
    @Autowired
    private final RegisterService registerService;
     */

    @Autowired
    private UserController userController;

    @PostMapping("/register")
    public ResponseEntity<?> userRegister (@RequestBody UserMetaData member) {
        return ResponseEntity.ok((createUser(member)));
    }

    public UserMetaData createUser (UserMetaData user) {

        //System.out.println(userController.findUserByAlias(user.getAlias()));
        return userController.insertUser(user);
    }
}
