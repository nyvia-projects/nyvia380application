package com.project.nyvia380server.common.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {

    @Id
    @JsonProperty("id")
    private String id;

    @JsonProperty("content")
    private String content;

    @JsonProperty("senderId")
    private UUID senderId;

    @JsonProperty("recipientId")
    private UUID recipientId;

    @JsonProperty("timestamp")
    private Date messageTime;

    @JsonProperty("type")
    private MessageType messageType;

    @JsonProperty("status")
    private MessageStatus messageStatus;

    public Message(String htmlEscape) {

    }

    public String getMessage() {

        return "empty message";
    }


    //private String receiver;


}
