package com.green.GreenClassRoom.board.service;

import com.green.GreenClassRoom.board.vo.QnaBookMarkVO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QnaBookMarkServiceImpl implements QnaBookMarkService {
    private final SqlSessionTemplate sqlSession;

    @Override
    public List<QnaBookMarkVO> selectBookMark(String memberId) {
        return sqlSession.selectList("qnaBookMarkMapper.selectBookMark", memberId);
    }

    @Override
    public int insertBookMark(QnaBookMarkVO qnaBookMarkVO) {
        return sqlSession.insert("qnaBookMarkMapper.insertBookMark", qnaBookMarkVO);
    }

    @Override
    public int deleteBookMark(QnaBookMarkVO qnaBookMarkVO) {
        return sqlSession.delete("qnaBookMarkMapper.deleteBookMark", qnaBookMarkVO);
    }
}
