package com.green.GreenClassRoom.board.service;

import com.green.GreenClassRoom.board.vo.QnaBoardVO;

import java.util.List;

public interface QnaBoardService {

    //질문게시판 글 작성 + 이미지 삽입
    public void insert(QnaBoardVO qnaBoardVO);

    //질문게시판 글 목록 조회
    public List<QnaBoardVO> selectQnaBoard(QnaBoardVO qnaBoardVO);

    //질문게시판 조회수 증가
    public int updateCnt(int qnaBoardNum);

    //게시글 상세 조회
    public QnaBoardVO qnaBoardDetail(int qnaBoardNum);

}
