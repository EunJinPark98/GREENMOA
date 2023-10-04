package com.green.GreenClassRoom.board.vo;

import lombok.Data;

@Data
public class FreeBoardVO {
    private int boardNum;
    private String title;
    private String content;
    private String writer;
    private String createDate;
    private int readCnt;
}
