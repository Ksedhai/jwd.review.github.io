package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.mapper.ChatMessageMapper;
import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private ChatMessageMapper chatMessageMapper;

    public MessageService(ChatMessageMapper chatMessageMapper){
        this.chatMessageMapper = chatMessageMapper;
    }

    public void addMessage(ChatForm chatForm){
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUsername(chatForm.getUsername());
        switch(chatForm.getType()){
            case "shout": chatMessage.setMessage(chatForm.getMessage().toUpperCase());
                break;
            case "whisper": chatMessage.setMessage(chatForm.getMessage().toLowerCase());
                break;
            default:chatMessage.setMessage(chatForm.getMessage());
        }
        chatMessageMapper.insert(chatMessage);
    }

    public List<ChatMessage> getChatMessages(){
        return chatMessageMapper.getAllMessages();
    }

}
