package com.green.GreenClassRoom.finalchat;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class WebSocketChatHandler extends TextWebSocketHandler {
    private static Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    private void broadcastMessage(String message) {
        for (WebSocketSession session : sessions.values()) {
            try {
                session.sendMessage(new TextMessage(message));
            } catch (IOException e) {
            }
        }
    }

    @Override  //연결
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // 세션 관리, 초기 설정
        sessions.put(session.getId(), session);
    }

    @Override  //메시지 전송
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        //메시지 처리, 다른 클라이언트로 메시지 브로드캐스트

        //메시지 수신
        String receivedMessage = message.getPayload();

//        System.out.println("제이슨 : " + receivedMessage);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> msgMap = objectMapper.readValue(receivedMessage, new TypeReference<Map<String, String>>() {});
//        System.out.println("정보 : " + msgMap);


        // 메시지 브로드캐스트
        broadcastMessage(receivedMessage);
    }

    @Override   //연결 닫힐 때
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
      sessions.remove(session.getId());
    }
}
