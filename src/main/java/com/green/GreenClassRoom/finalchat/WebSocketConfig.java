package com.green.GreenClassRoom.finalchat;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    private final WebSocketChatHandler webSocketChatHandler;

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // 메시지 브로커
        config.enableSimpleBroker("/"); // 모두에게 메세지 전달
        config.setApplicationDestinationPrefixes("/app"); // 메시지를 수신 엔드포인트
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // WebSocket 엔드포인트
        registry.addEndpoint("/chat")
                .withSockJS();
    }
}