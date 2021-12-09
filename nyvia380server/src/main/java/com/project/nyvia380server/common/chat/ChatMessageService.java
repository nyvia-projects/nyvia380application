package com.project.nyvia380server.common.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

@Service
public class ChatMessageService {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    public MessageMetaData sendMessage (MessageMetaData message) throws Exception {
        return MessageMetaData.builder().build();
    }

    public void sendMessageTo (MessageMetaData message, String userName) throws Exception {
//        if (UserStorage.getInstance().contains(userName))
//            Thread.sleep(500);
        simpMessagingTemplate.convertAndSend("/topic/chat/" + userName, message);
    }

    public void fetchAllMessages (String userName) {
        //TODO: fetch all messages for particular user.
    }
}
