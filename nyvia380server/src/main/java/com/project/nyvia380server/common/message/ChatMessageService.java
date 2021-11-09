package com.project.nyvia380server.common.message;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

@Service
public class ChatMessageService {

    private SimpMessagingTemplate simpMessagingTemplate;

    public Message sendMessage (Message message) throws Exception {
        return new Message(HtmlUtils.htmlEscape(message.getMessage()));
    }

    public void sendMessageTo (Message message, String userName) throws Exception {
//        if (UserStorage.getInstance().contains(userName))
//            Thread.sleep(500);
        simpMessagingTemplate.convertAndSend("/topic/chat/" + userName, message);
    }

    public void fetchAllMessages (String userName) {
        //TODO: fetch all messages for particular user.
    }
}
