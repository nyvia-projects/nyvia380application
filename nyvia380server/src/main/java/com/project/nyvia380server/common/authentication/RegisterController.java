package com.project.nyvia380server.common.authentication;

import com.project.nyvia380server.common.authentication.JWT.JwtRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class RegisterController {

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void registerUser (@RequestBody JwtRequest authenticationRequest) {

        System.out.println("TESTING TESTING 1 2 3");
    }
}
