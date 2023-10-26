package com.green.GreenClassRoom.board.service;

import com.green.GreenClassRoom.board.vo.BookMarkVO;

import java.util.List;

public interface BookMarkService {

    //게시글 북마크 조회
    public List<BookMarkVO> selectBookMark(String memberId);

    //게시글 북마크 등록
    public int insertBookMark(BookMarkVO bookMarkVO);

    //게시글 북마크 취소
    public int deleteBookMark(BookMarkVO bookMarkVO);
}
