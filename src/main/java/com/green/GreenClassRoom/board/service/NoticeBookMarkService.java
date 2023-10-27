package com.green.GreenClassRoom.board.service;

import com.green.GreenClassRoom.board.vo.NoticeBookMarkVO;

import java.util.List;

public interface NoticeBookMarkService {

    //공지사항 북마크 조회
    public List<NoticeBookMarkVO> selectNoticeBookMark(String memberId);

    //공지사항 북마크 등록
    public int insertNoticeBookMark(NoticeBookMarkVO noticeBookMarkVO);

    //공지사항 북마크 삭제
    public int deleteNoticeBookMark(NoticeBookMarkVO noticeBookMarkVO);
}
