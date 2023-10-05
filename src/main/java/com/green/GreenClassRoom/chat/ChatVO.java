package com.green.GreenClassRoom.chat;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChatVO {
    private String memberId;
    private String memberName;
    private String message;
    private LocalDateTime timestamp;

}
