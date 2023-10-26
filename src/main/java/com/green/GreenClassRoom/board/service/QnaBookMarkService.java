package com.green.GreenClassRoom.board.service;

import com.green.GreenClassRoom.board.vo.QnaBookMarkVO;

import java.util.List;

public interface QnaBookMarkService {

    //게시글 북마크 조회
    public List<QnaBookMarkVO> selectBookMark(String memberId);

    //게시글 북마크 등록
    public int insertBookMark(QnaBookMarkVO qnaBookMarkVO);

    //게시글 북마크 취소
    public int deleteBookMark(QnaBookMarkVO qnaBookMarkVO);
}
