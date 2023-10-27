package com.green.GreenClassRoom.board.service;

import com.green.GreenClassRoom.board.vo.NoticeBookMarkVO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeBookMarkServiceImpl implements NoticeBookMarkService{
    private final SqlSessionTemplate sqlSession;

    @Override
    public List<NoticeBookMarkVO> selectNoticeBookMark(String memberId) {
        return sqlSession.selectList("noticeBookMarkMapper.selectNoticeBookMark", memberId);
    }

    @Override
    public int insertNoticeBookMark(NoticeBookMarkVO noticeBookMarkVO) {
        return sqlSession.insert("noticeBookMarkMapper.insertNoticeBookMark", noticeBookMarkVO);
    }

    @Override
    public int deleteNoticeBookMark(NoticeBookMarkVO noticeBookMarkVO) {
        return sqlSession.delete("noticeBookMarkMapper.deleteNoticeBookMark", noticeBookMarkVO);
    }
}
