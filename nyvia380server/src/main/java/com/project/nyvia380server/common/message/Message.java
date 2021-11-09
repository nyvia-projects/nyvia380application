package com.project.nyvia380server.common.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.nyvia380server.common.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {

    @Id
    @JsonProperty("id")
    private String id;

    @JsonProperty("data")
    private String message;

    @JsonProperty("sender")
    private User sender;

    @JsonProperty("time")
    private Date messageTime;

    @JsonProperty("type")
    private MessageType messageType;

    public Message(String htmlEscape) {

    }


    //private String receiver;


}
