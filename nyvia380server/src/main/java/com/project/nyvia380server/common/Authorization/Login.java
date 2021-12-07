package com.project.nyvia380server.common.Authorization;


import com.project.nyvia380server.common.user.Member;
import com.project.nyvia380server.common.user.UserController;
import com.project.nyvia380server.common.user.UserMetaData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class Login {

    @Autowired
    private UserController userController;

    @PostMapping("/login")
    public ResponseEntity<?> userLogin (@RequestBody UserMetaData member) {

        System.out.println("LOGGIN IN");

        UserMetaData newMember = createUser(member);

        return ResponseEntity.ok((member));
    }

    private UserMetaData createUser (UserMetaData user) {
        System.out.println(user);
        return userController.insertUser(user);
    }
}
