package com.green.GreenClassRoom.board.service;

import com.green.GreenClassRoom.board.vo.QnaBoardVO;

import java.util.List;

public interface QnaBoardService {

    //질문게시판 글 작성
    public void insert(QnaBoardVO qnaBoardVO);

    //질문게시판 글 목록 조회
    public List<QnaBoardVO> selectQnaBoard(QnaBoardVO qnaBoardVO);

}
