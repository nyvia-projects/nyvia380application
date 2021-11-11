package com.project.nyvia380server.common.user;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.nyvia380server.common.user.group.Group;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;
import java.util.Set;
import java.util.UUID;

import static com.project.nyvia380server.common.user.Privilege.NONE;

@Document(collection = "Users")
@Data
@Jacksonized // Enables Jackson deserialization for Builder
@SuperBuilder
@RequiredArgsConstructor(onConstructor = @__(@PersistenceConstructor)) //Makes ReqArgsCons to be @PersistCons
public class Member implements User {

    @Id
    @NotNull
    @JsonProperty("id")
    protected final UUID id;
    @NotNull
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
    protected Set<Group> groups;

    protected Set<Group> addGroup(Group group) {
        this.groups.add(group);
        return this.groups;
    }



}
