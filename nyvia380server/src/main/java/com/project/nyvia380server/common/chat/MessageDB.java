package com.project.nyvia380server.common.chat;

import com.project.nyvia380server.common.chat.Message;
import com.project.nyvia380server.common.chat.MessageMetaData;

import java.util.ArrayList;

public class MessageDB {

    private ArrayList<MessageMetaData> messageList = new ArrayList<>();

    public void addMessage (MessageMetaData message) {
        messageList.add(message);
    }

    public ArrayList<MessageMetaData> getMessagesByAlias (String alias) {
        ArrayList<MessageMetaData> newMessageList = new ArrayList<>();

        for (MessageMetaData message: messageList)
            if (message.getSender().equals(alias) || message.getReceiver().equals(alias))
                newMessageList.add(message);

        return newMessageList;
    }
}
