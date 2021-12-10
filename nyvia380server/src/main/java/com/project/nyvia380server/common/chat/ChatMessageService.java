package com.project.nyvia380server.common.chat;

import com.project.nyvia380server.common.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.project.nyvia380server.Nyvia380Application.messageDB;

@Service
@RequiredArgsConstructor
public class ChatMessageService {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private UserService userService;

    public MessageMetaData sendMessage (MessageMetaData message) throws Exception {
        return MessageMetaData.builder().build();
    }

    public void sendMessageTo (MessageMetaData message, String userName) throws Exception {
        if (userService.findUserByAlias(userName).getAlias().equals(userName)) {
            simpMessagingTemplate.convertAndSend("/topic/chat/" + userName, message);
            messageDB.addMessage(message);
        }
    }

    public ArrayList<MessageMetaData> fetchAllMessages (String userName) {
        return messageDB.getMessagesByAlias(userName);
    }
}
