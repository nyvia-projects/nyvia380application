package com.project.nyvia380server.common.user;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.nyvia380server.common.user.group.Group;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.*;
import java.util.Set;


@Value
@Jacksonized
@Builder
@AllArgsConstructor
public class UserMetaData {

    @NotNull @NotBlank @NotEmpty(message = "First name cannot be empty!")
    @JsonProperty("firstName")
    String firstName;

    @NotNull @NotBlank @NotEmpty(message = "Last name cannot be empty!")
    @JsonProperty("lastName")
    String lastName;

    @Max(value = 110, message = "Invalid age!") @Min(value = 16, message = "Must be older than 16!")
    @JsonProperty("age")
    int age;

    @NotNull
    @JsonProperty("privilege")
    Privilege privilege;

    @NotNull
    @JsonProperty("alias")
    String alias;

    //@Singular
    @JsonProperty("groups")
    Set<Group> groups;


}

