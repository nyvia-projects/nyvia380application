package com.project.nyvia380server.common.user;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
@RequiredArgsConstructor
@Getter
public class User {

    @Id
    private String userID;

    private String userName;


    @JsonCreator
    public User(@JsonProperty("id") String id, @JsonProperty("name") String name) {
        this.userID = id;
        this.userName = name;
    }

}
