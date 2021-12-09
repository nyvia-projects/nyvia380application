package com.project.nyvia380server.common.chat;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


@Controller
public class ChatAppController {

    private final ChatMessageService chatMessageService;

    @Autowired
    public ChatAppController(ChatMessageService chatMessageService) {
        this.chatMessageService = chatMessageService;
    }

    private ModelMapper modelMapper;

    private Message convertToEntity(MessageMetaData dto) { return modelMapper.map(dto, Message.class); }


    @MessageMapping("/chat")
    @SendTo("/topic/chat")
    public MessageMetaData sendMessage (MessageMetaData message) throws Exception {
        System.out.println(message);
        return chatMessageService.sendMessage(message);
    }

    @MessageMapping("/chat/{userName}")
    public void sendMessageTo (MessageMetaData message, @DestinationVariable String userName) throws Exception {
        chatMessageService.sendMessageTo(message, userName);
    }

    @MessageMapping("/chat/{userName}/fetchAllMessages")
    public void fetchAllMessages (@DestinationVariable String userName) {
        chatMessageService.fetchAllMessages(userName);
    }
}
