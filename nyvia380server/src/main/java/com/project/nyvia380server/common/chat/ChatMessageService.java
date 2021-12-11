package com.project.nyvia380server.common.chat;

import com.project.nyvia380server.common.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatMessageService {

    //@Autowired
    private final SimpMessagingTemplate simpMessagingTemplate;

    //@Autowired
    private final UserService userService;

    //    @Autowired
    private final MessageRepository messageRepository;

    public MessageMetaData sendMessage(MessageMetaData message) throws Exception {
        return MessageMetaData.builder()
                .build();
    }

    public void sendMessageTo(Message message, String userName) throws Exception {
        if (userService.findUserByAlias(userName)
                .getAlias()
                .equals(userName)) {
            simpMessagingTemplate.convertAndSend("/topic/chat/" + userName, message);
            messageRepository.insert(message);
        }
    }

    public List<Message> fetchAllMessages(String userName) {
        return messageRepository.findAll()
                .stream()
                .filter(message ->
                        message.getReceiver().equals(userName)
                        ||
                        message.getSender().equals(userName))
                .collect(Collectors.toList());
    }


}
