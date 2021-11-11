package com.project.nyvia380server.common.user;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.nyvia380server.common.user.group.Group;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.*;
import java.util.Set;
import java.util.UUID;

import static com.project.nyvia380server.common.user.Privilege.NONE;

//@Data
//@SuperBuilder
public class UserClient {//extends Member{


   /* @NotNull
    @NotBlank
    @NotEmpty(message = "First name cannot be empty!")
    @JsonProperty("firstName")
    protected final String firstName;
    @NotNull
    @NotBlank
    @NotEmpty(message = "Last name cannot be empty!")
    @JsonProperty("lastName")
    protected final String lastName;
    @Max(value = 110, message = "Invalid age!")
    @Min(value = 16, message = "Must be older than 16!")
    @JsonProperty("age")
    protected final int age;
    @Builder.Default // clears initialization of annotated field
    @NotNull
    @JsonProperty("privilege")
    protected final Privilege privilege = NONE;
    //@NotNull
    @JsonProperty("alias")
    protected String alias;
    @JsonProperty("groups")
    protected Set<Group> groups;*/




}
