package com.project.nyvia380server.common.chat;

import com.project.nyvia380server.common.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatMessageService {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private UserService userService;

    private MessageRepository messageRepository;

    public MessageMetaData sendMessage (MessageMetaData message) throws Exception {
        return MessageMetaData.builder().build();
    }

    public void sendMessageTo (MessageMetaData message, String userName) throws Exception {
        if (userService.findUserByAlias(userName).getAlias().equals(userName))
            simpMessagingTemplate.convertAndSend("/topic/chat/" + userName, message);
    }

    public void fetchAllMessages (String userName) {
        //TODO: fetch all messages for particular user.
    }
}
