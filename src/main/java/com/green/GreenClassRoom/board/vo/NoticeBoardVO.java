package com.green.GreenClassRoom.board.vo;

import lombok.Data;

@Data
public class NoticeBoardVO extends QnaPageVO{
    private int noticeBoardNum;
    private String noticeBoardTitle;
    private String noticeBoardContent;
    private String memberId;
    private String noticeBoardCreateDate;
    private int noticeBoardReadCnt;

    private String searchType;
    private String searchValue;
}
