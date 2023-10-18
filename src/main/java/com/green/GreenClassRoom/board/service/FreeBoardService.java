package com.green.GreenClassRoom.board.service;

import com.green.GreenClassRoom.board.vo.FreeBoardVO;
import com.green.GreenClassRoom.board.vo.ReplyVO;

import java.util.List;

public interface FreeBoardService {
    // 게시판 목록 조회 쿼리 메소드
    public List<FreeBoardVO> selectFreeBoardList(FreeBoardVO freeBoardVO);

    // 게시판 글 등록 쿼리 메소드
    public int insertFreeBoard(FreeBoardVO freeBoardVO);

    // 게시판 번호를 기준으로 상세게시글 보기
    public FreeBoardVO selectFreeBoardDetail(int boardNum);

    // 조회 수 카운트 증가 기능
    public int readCntUp(int boardNum);

    // 게시판 수정 기능
    public int updateFreeBoard(FreeBoardVO freeBoardVO);

    // 게시판 삭제 기능
    public int deleteFreeBoard(int boardNum);

    // 댓글 작성
    public int insertReply(ReplyVO replyVO);

    // 댓글 조회
    public List<ReplyVO> selectReply(ReplyVO replyVO);

    // 댓글 선택 삭제 기능
    public int deleteReply(int replyNum);

    // 자유게시판 페이징
    public int pagingFreeBoard();

}
