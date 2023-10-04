package com.green.GreenClassRoom.board.service;

import com.green.GreenClassRoom.board.vo.FreeBoardVO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FreeBoardServiceImpl implements FreeBoardService{
    private final SqlSessionTemplate sqlSession;

    @Override
    public List<FreeBoardVO> selectFreeBoardList(FreeBoardVO freeBoardVO) {
        return sqlSession.selectList("freeBoardMapper.selectFreeBoardList",freeBoardVO);
    }

    @Override
    public int insertFreeBoard(FreeBoardVO freeBoardVO) {
        return sqlSession.insert("freeBoardMapper.insertFreeBoard",freeBoardVO);
    }
}
