package com.green.GreenClassRoom.finalchat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @MessageMapping("/chat")
    @SendTo("/topic")
    public ChatVO sendMessage(ChatVO message) {
        System.out.println("이건 왜 안나오냐");

        return message;
    }


}