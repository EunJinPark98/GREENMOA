package com.green.GreenClassRoom.finalchat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @MessageMapping("/chat")
    @SendTo("/")
    public ChatMessage sendMessage(ChatMessage message) {
        System.out.println("@@@@@@@@@@@@@@@" + message);
        System.out.println(message.getContent());

        return message;
    }


}