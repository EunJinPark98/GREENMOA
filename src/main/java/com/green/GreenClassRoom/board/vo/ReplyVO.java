package com.green.GreenClassRoom.board.vo;

import lombok.Data;

@Data
public class ReplyVO {
    private int replyNum;
    private int boardNum;
    private String replyText;
    private String replyer;
    private String regDate;
    private String updateDate;
}
