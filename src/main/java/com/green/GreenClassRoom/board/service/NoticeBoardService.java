package com.green.GreenClassRoom.board.service;

import com.green.GreenClassRoom.board.vo.NoticeBoardVO;

import java.util.List;

public interface NoticeBoardService {
    //공지사항 목록 조회
    public List<NoticeBoardVO> selectNoticeList(NoticeBoardVO noticeBoardVO);

    //공지사항 글쓰기
    public int insertNotice(NoticeBoardVO noticeBoardVO);

    //공지 상세페이지
    public NoticeBoardVO noticeBoardDetail(int noticeBoardNum);

    //조회수
    public int updateReadCnt(int noticeBoardNum);

    //공지 삭제
    public int deleteNotice(int noticeBoardNum);

    //공지 수정
    public int updateNotice(NoticeBoardVO noticeBoardVO);

    //페이징
    public int pagingNotice();

}
