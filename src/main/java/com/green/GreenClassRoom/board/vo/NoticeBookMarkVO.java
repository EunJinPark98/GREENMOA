package com.green.GreenClassRoom.board.vo;

import lombok.Data;

@Data
public class NoticeBookMarkVO {
    private int noticeBookMarkNum;
    private int noticeBoardNum;
    private String memberId;
    private NoticeBoardVO noticeBoardVO;
}
