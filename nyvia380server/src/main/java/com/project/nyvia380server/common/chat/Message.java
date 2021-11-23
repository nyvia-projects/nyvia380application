package com.project.nyvia380server.common.chat;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document("Messages")
@Builder
@Getter
@AllArgsConstructor
@RequiredArgsConstructor(onConstructor = @__(@PersistenceConstructor))
public class Message {

    @Id
    private String id;
    private final String content;
    private final String  senderId;
    private final String  recipientId;
    private final Date messageTime;
    private final MessageType messageType; // request type
    private final MessageStatus messageStatus; // message status


//    public Message(String htmlEscape) {
//
//    }
//
//    public String getMessage() {
//
//        return "empty message";
//    }


    //private String receiver;


}
