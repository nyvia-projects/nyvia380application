package com.project.nyvia380server.common.authentication;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class Person {

    private final String username;
    private final String password;
}
