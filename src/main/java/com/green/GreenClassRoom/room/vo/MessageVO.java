package com.green.GreenClassRoom.room.vo;

import lombok.Data;

@Data
public class MessageVO {
    private int messageNum;
    private String memberName;
    private String memberId;
    private String messageContent;
    private String messageDate;
}
