package com.green.GreenClassRoom.board.service;

import com.green.GreenClassRoom.board.vo.QnaBoardVO;
import com.green.GreenClassRoom.board.vo.QnaReplyVO;
import com.green.GreenClassRoom.board.vo.ReplyVO;

import java.util.List;

public interface QnaBoardService {

    //질문게시판 글 작성 + 이미지 삽입
    public void insert(QnaBoardVO qnaBoardVO);

    //질문게시판 글 목록 조회
    public List<QnaBoardVO> selectQnaBoard(QnaBoardVO qnaBoardVO);

    //질문게시판 조회수 증가
    public int updateCnt(int qnaBoardNum);

    //질문게시판 상세 조회
    public QnaBoardVO qnaBoardDetail(int qnaBoardNum);

    //질문게시판 삭제
    public int deleteQnaBoard(int qnaBoardNum);

    //질문게시판 수정
    public int updateQnaBoard(QnaBoardVO qnaBoardVO);

    //질문게시판 첨부파일 삭제
    public int deleteFile(QnaBoardVO qnaBoardVO);

    //질문게시판 첨부파일 수정
    public int updateFile(QnaBoardVO qnaBoardVO);

    //질문게시판 첨부파일 첨부
    public int insertFile(QnaBoardVO qnaBoardVO);

    //질문게시판 페이징
    public int selectQnaBoardCnt();

    // 답변 작성
    public int insertQnaReply(QnaReplyVO qnaReplyVO);

    // 답변 조회
    public List<QnaReplyVO> selectQnaReply(QnaReplyVO qnaReplyVO);

    // 답변 선택 삭제 기능
    public void deleteQnaReply(QnaReplyVO qnaReplyVO);

}
