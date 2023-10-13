package com.green.GreenClassRoom.finalchat;

//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.simp.config.MessageBrokerRegistry;
//import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
//import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
//import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
//
//@Configuration
//@EnableWebSocketMessageBroker
//@RequiredArgsConstructor
//public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
//    //private final WebSocketChatHandler webSocketChatHandler;
//
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry config) {
//        // 메시지 브로커
//        config.enableSimpleBroker("/topic"); // 메시지 브로커
//        config.setApplicationDestinationPrefixes("/app"); // 메시지 수신 엔드포인트
//    }
//
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        // WebSocket 엔드포인트
//        registry.addEndpoint("/chat")
//                .setAllowedOriginPatterns("*")
//                .withSockJS();
//
//        //registry.addHandler(webSocketChatHandler, "/chat");
//    }
//}

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new WebSocketChatHandler(), "/chat")
                .setAllowedOriginPatterns("*");
                //.withSockJS();
    }
}