package com.green.GreenClassRoom.board.vo;

import lombok.Data;
import lombok.Getter;

@Data
public class FreeBookMarkVO {
    private int freeBookMarkNum;
    private int boardNum;
    private String memberId;
    private FreeBoardVO freeBoardVO;

}
