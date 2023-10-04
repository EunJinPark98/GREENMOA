package com.green.GreenClassRoom.board.service;

import com.green.GreenClassRoom.board.vo.FreeBoardVO;

import java.util.List;

public interface FreeBoardService {
    // 게시판 목록 조회 쿼리 메소드
    public List<FreeBoardVO> selectFreeBoardList(FreeBoardVO freeBoardVO);

    // 게시판 글 등록 쿼리 메소드
    public int insertFreeBoard(FreeBoardVO freeBoardVO);


}
