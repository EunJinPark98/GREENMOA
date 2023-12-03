package com.green.GreenClassRoom.finalchat;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class WebSocketChatHandler extends TextWebSocketHandler {
    private static Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    private void broadcastMessage(String message) {
        List<WebSocketSession> sessionsToRemove = new ArrayList<>();

        for (WebSocketSession session : sessions.values()) {
            try {
                session.sendMessage(new TextMessage(message));
            } catch (IOException e) {
                sessionsToRemove.add(session);
            }
        }
        // 예외가 발생한 세션들 제거
        for (WebSocketSession session : sessionsToRemove) {
            sessions.remove(getSessionId(session));
        }
    }

    @Override //연결 (세션 관리, 초기 설정)
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.put(session.getId(), session);
    }

    @Override //메시지 브로드캐스트
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String receivedMessage = message.getPayload();
        broadcastMessage(receivedMessage);
    }

    @Override //연결 닫힘
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session.getId());
    }

    private String getSessionId(WebSocketSession session) {
        return session.getId();
    }
}
