package com.green.GreenClassRoom.board.service;

import com.green.GreenClassRoom.board.vo.NoticeBoardVO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class NoticeBoardServiceImpl implements NoticeBoardService{
    private final SqlSessionTemplate sqlSession;

    //공지사항 목록 조회
    @Override
    public List<NoticeBoardVO> selectNoticeList(NoticeBoardVO noticeBoardVO) {
        return sqlSession.selectList("noticeBoardMapper.selectNoticeList",noticeBoardVO);
    }

    //공지사항 글쓰기
    @Override
    public int insertNotice(NoticeBoardVO noticeBoardVO) {
        return sqlSession.insert("noticeBoardMapper.insertNotice",noticeBoardVO);
    }

    //공지 상세페이지
    @Override
    public NoticeBoardVO noticeBoardDetail(int noticeBoardNum) {
        return sqlSession.selectOne("noticeBoardMapper.noticeBoardDetail", noticeBoardNum);
    }

    //조회수
    @Override
    public int updateReadCnt(int noticeBoardNum) {
        return sqlSession.update("noticeBoardMapper.updateReadCnt", noticeBoardNum);
    }

    //공지 삭제
    @Override
    public int deleteNotice(int noticeBoardNum) {
        return sqlSession.delete("noticeBoardMapper.deleteNotice", noticeBoardNum);
    }

    //공지 수정
    @Override
    public int updateNotice(NoticeBoardVO noticeBoardVO) {
        return sqlSession.update("noticeBoardMapper.updateNotice", noticeBoardVO);
    }

    //페이징
    @Override
    public int pagingNotice() {
        return sqlSession.selectOne("noticeBoardMapper.pagingNotice");
    }

    //상세페이지에서 이전글 다음글
    @Override
    public NoticeBoardVO prevList(int noticeBoardNum) {
        return sqlSession.selectOne("noticeBoardMapper.prevList", noticeBoardNum);
    }
    @Override
    public NoticeBoardVO nextList(int noticeBoardNum) {
        return sqlSession.selectOne("noticeBoardMapper.nextList", noticeBoardNum);
    }
}
