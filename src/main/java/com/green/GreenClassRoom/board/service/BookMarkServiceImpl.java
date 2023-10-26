package com.green.GreenClassRoom.board.service;

import com.green.GreenClassRoom.board.vo.BookMarkVO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookMarkServiceImpl implements BookMarkService{
    private final SqlSessionTemplate sqlSession;

    @Override
    public List<BookMarkVO> selectBookMark(String memberId) {
        return sqlSession.selectList("bookMarkMapper.selectBookMark", memberId);
    }

    @Override
    public int insertBookMark(BookMarkVO bookMarkVO) {
        return sqlSession.insert("bookMarkMapper.insertBookMark", bookMarkVO);
    }

    @Override
    public int deleteBookMark(BookMarkVO bookMarkVO) {
        return sqlSession.delete("bookMarkMapper.deleteBookMark", bookMarkVO);
    }
}
