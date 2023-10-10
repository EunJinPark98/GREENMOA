package com.green.GreenClassRoom.board.vo;

import lombok.Data;

import java.util.List;

@Data
public class QnaBoardVO {
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
