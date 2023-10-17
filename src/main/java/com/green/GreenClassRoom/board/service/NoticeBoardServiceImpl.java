package com.green.GreenClassRoom.board.service;

import com.green.GreenClassRoom.board.vo.NoticeBoardVO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
