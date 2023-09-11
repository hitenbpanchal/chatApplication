package com.chatapp.chat;

import com.chatapp.models.ChatMessages;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Objects;

@Controller
public class ChatController {
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessages sendMessage(@Payload ChatMessages message) {
        return message;
    }
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessages addUser(@Payload ChatMessages message, SimpMessageHeaderAccessor headerAccessor) {
        //add username in the socket session
        Objects.requireNonNull(headerAccessor.getSessionAttributes()).put("username",message.getSender());
        return message;
    }
}
