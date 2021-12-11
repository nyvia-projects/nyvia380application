package com.project.nyvia380server.common.chat;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@Controller
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class ChatAppController {

    private final ChatMessageService chatMessageService;

    private final ModelMapper modelMapper;

    private Message convertToEntity(MessageMetaData dto) {
        return modelMapper.map(dto, Message.class);
    }


    private MessageMetaData convertToDTO(Message message) {
        return modelMapper.map(message, MessageMetaData.MessageMetaDataBuilder.class)
                .build();
    }

    private Message convertToEntity(Message dto) {
        return modelMapper.map(dto, Message.class);
    }

    /*  @MessageMapping("/chat") FIXME might delete
      @SendTo("/topic/chat")
      public MessageMetaData sendMessage (MessageMetaData message) throws Exception {
          return chatMessageService.sendMessage(message);
      }
  */
    @MessageMapping("/chat/{userName}")
    public void sendMessageTo(MessageMetaData dto, @DestinationVariable String userName) throws Exception {
        chatMessageService.sendMessageTo(convertToEntity(dto), userName);
    }

    @GetMapping("/chat/{userName}/fetchAllMessages")
    public List<MessageMetaData> fetchAllMessages(@PathVariable String userName) throws NullPointerException{
        return chatMessageService.fetchAllMessages(userName)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


}
