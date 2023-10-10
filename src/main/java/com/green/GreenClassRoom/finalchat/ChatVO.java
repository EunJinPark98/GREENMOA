<<<<<<<< HEAD:src/main/java/com/green/GreenClassRoom/chat2/ChatVO.java
package com.green.GreenClassRoom.chat2;
========
package com.green.GreenClassRoom.finalchat;
>>>>>>>> hyeopjin:src/main/java/com/green/GreenClassRoom/finalchat/ChatVO.java

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChatVO {
    private String memberId;
    private String memberName;
    private String message;
    private LocalDateTime timestamp;

}
