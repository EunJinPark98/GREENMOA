package com.green.GreenClassRoom.board.vo;

import lombok.Data;

@Data
public class QnaBoardVO extends QnaPageVO {
    private int qnaBoardNum;
    private String qnaBoardTitle;
    private String qnaBoardContent;
    private String qnaBoardWriter;
    private String qnaCreateDate;
    private String qnaReadCnt;
    private String searchText;
    private String searchType;
    private String originFileName;
    private String attachedFileName;
}
