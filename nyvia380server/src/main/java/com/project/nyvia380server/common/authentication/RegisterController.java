package com.project.nyvia380server.common.authentication;

import com.project.nyvia380server.common.authentication.JWT.JwtResponse;
import com.project.nyvia380server.common.authentication.JWT.JwtTokenUtil;
import com.project.nyvia380server.common.authentication.JWT.JwtUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class RegisterController {

    private JwtTokenUtil jwtTokenUtil;

    private JwtUserDetailsService userDetailsService;


    @PostMapping("/register")
    public ResponseEntity<PersonMetaData> registerUser (PersonMetaData personMetaData) {

        System.out.println(personMetaData);

        //final UserDetails userDetails = new User(user.username, user.password, new ArrayList<>());

        //final String token = jwtTokenUtil.generateToken(userDetails);
        String token = "test";

        return ResponseEntity.ok(personMetaData.builder().build());
    }
}
