package com.green.GreenClassRoom.board.service;

import com.green.GreenClassRoom.board.vo.FreeBookMarkVO;

import java.util.List;

public interface FreeBookMarkService {

    //자유게시판 북마크 조회
    public List<FreeBookMarkVO> selectFreeBookMark(String memberId);

    //자유게시판 북마크 등록
    public int insertFreeBookMark(FreeBookMarkVO freeBookMarkVO);

    //자유게피산 북마크 삭제
    public int deleteFreeBookMark(FreeBookMarkVO freeBookMarkVO);
}
