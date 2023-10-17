package com.green.GreenClassRoom.board.service;

import com.green.GreenClassRoom.board.vo.NoticeBoardVO;

import java.util.List;

public interface NoticeBoardService {
    //공지사항 목록 조회
    public List<NoticeBoardVO> selectNoticeList(NoticeBoardVO noticeBoardVO);

    //공지사항 글쓰기
    public int insertNotice(NoticeBoardVO noticeBoardVO);
}
