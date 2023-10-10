<<<<<<<< HEAD:src/main/java/com/green/GreenClassRoom/chat2/WebSocketChatHandler.java
package com.green.GreenClassRoom.chat2;
========
package com.green.GreenClassRoom.finalchat;
>>>>>>>> hyeopjin:src/main/java/com/green/GreenClassRoom/finalchat/WebSocketChatHandler.java

import com.fasterxml.jackson.databind.ObjectMapper;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@Component
@RequiredArgsConstructor
public class WebSocketChatHandler extends TextWebSocketHandler {
    private final ObjectMapper objectMapper;


}
