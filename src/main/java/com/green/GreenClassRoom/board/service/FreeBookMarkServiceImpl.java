package com.green.GreenClassRoom.board.service;

import com.green.GreenClassRoom.board.vo.FreeBookMarkVO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FreeBookMarkServiceImpl implements FreeBookMarkService{
    private final SqlSessionTemplate sqlSession;

    @Override
    public List<FreeBookMarkVO> selectFreeBookMark(String memberId) {
        return sqlSession.selectList("freeBookMarkMapper.selectFreeBookMark", memberId);
    }

    @Override
    public int insertFreeBookMark(FreeBookMarkVO freeBookMarkVO) {
        return sqlSession.insert("freeBookMarkMapper.insertFreeBookMark", freeBookMarkVO);
    }

    @Override
    public int deleteFreeBookMark(FreeBookMarkVO freeBookMarkVO) {
        return sqlSession.delete("freeBookMarkMapper.deleteFreeBookMark", freeBookMarkVO);
    }
}
