package com.project.nyvia380server.common.authentication;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Value
@Jacksonized
@Builder
@AllArgsConstructor
public class PersonMetaData {

    @NotNull @NotBlank @NotEmpty(message = "Username cannot be empty!")
    @JsonProperty("username")
    String username;

    @NotNull @NotBlank @NotEmpty(message = "Password cannot be empty!")
    @JsonProperty("password")
    String password;
}
