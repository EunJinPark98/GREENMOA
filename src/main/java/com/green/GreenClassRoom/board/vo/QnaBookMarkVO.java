package com.green.GreenClassRoom.board.vo;

import lombok.Data;

@Data
public class QnaBookMarkVO {
    private int qnaBookMarkNum;
    private int qnaBoardNum;
    private String memberId;
    private QnaBoardVO qnaBoardVO;
}
