package com.green.GreenClassRoom.board.service;

import com.green.GreenClassRoom.board.vo.QnaBoardVO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QnaBoardServiceImpl implements QnaBoardService{
    private final SqlSessionTemplate sqlSession;

    @Override
    public void insert(QnaBoardVO qnaBoardVO) {
        sqlSession.insert("qnaBoardMapper.insert", qnaBoardVO);
    }

    @Override
    public List<QnaBoardVO> selectQnaBoard(QnaBoardVO qnaBoardVO) {
        return sqlSession.selectList("qnaBoardMapper.selectQnaBoard", qnaBoardVO);
    }

    @Override
    public int updateCnt(int qnaBoardNum) {
        return sqlSession.update("qnaBoardMapper.updateCnt", qnaBoardNum);
    }

    @Override
    public QnaBoardVO qnaBoardDetail(int qnaBoardNum) {
        return sqlSession.selectOne("qnaBoardMapper.qnaBoardDetail", qnaBoardNum);
    }
}
