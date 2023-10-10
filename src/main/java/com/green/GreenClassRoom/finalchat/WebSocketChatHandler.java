package com.green.GreenClassRoom.finalchat;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketChatHandler extends TextWebSocketHandler {
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // 클라이언트가 연결될 때 호출됩니다.
        // 세션을 관리하거나 초기 설정을 수행할 수 있습니다.
        System.out.println("연결됐다~~~!!");
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 클라이언트가 메시지를 전송할 때 호출됩니다.
        // 받은 메시지를 처리하고, 다른 클라이언트로 메시지를 브로드캐스트할 수 있습니다.
        System.out.println(message);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // 클라이언트 연결이 닫힐 때 호출됩니다.
        // 연결 종료 시 필요한 정리 작업을 수행할 수 있습니다.
        System.out.println("연결 닫았다~~~!!!");
    }

}
