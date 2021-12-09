package com.project.nyvia380server.common.chat;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Map;

@Value
@Jacksonized
@Builder
//@AllArgsConstructor
public class MessageMetaData {

    /*
    @NotNull @NotEmpty
    @JsonProperty("id")
    Map<String, String> id;

    @NotNull
    @JsonProperty("content")
    String content;

    @NotNull @NotBlank @NotEmpty
    @JsonProperty("senderId")
    String senderId;

    @NotNull @NotBlank @NotEmpty
    @JsonProperty("recipientId")
    String recipientId;


    @NotNull @NotBlank @NotEmpty
    @JsonProperty("timestamp")
    Date messageTime;

    @NotNull
    @JsonProperty("type")
    MessageType messageType;


    @NotNull
    @JsonProperty("status")
    MessageStatus messageStatus;

     */

    @NotNull
    @JsonProperty("sender")
    String sender;

    @NotNull
    @JsonProperty("receiver")
    String receiver;

    @NotNull
    @JsonProperty("message")
    String message;

}
