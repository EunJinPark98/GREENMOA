package com.green.GreenClassRoom.room.service;

import com.green.GreenClassRoom.member.vo.MemberVO;
import com.green.GreenClassRoom.room.vo.LetterVO;
import com.green.GreenClassRoom.room.vo.menuVO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService{
    private final SqlSessionTemplate sqlSession;

    @Override
    public List<menuVO> selectMenuList() {
        return sqlSession.selectList("menuMapper.selectMenuList");
    }

    @Override
    public int updateStatusMsg(MemberVO memberVO) {
        return sqlSession.update("memberMapper.updateStatusMsg",memberVO);
    }

    @Override
    public MemberVO selectStatusMsg(String memberId) {
        return sqlSession.selectOne("memberMapper.selectStatusMsg",memberId);
    }

    @Override
    public void insertLetter(LetterVO letterVO) {
        sqlSession.insert("letterMapper.insertLetter",letterVO);
    }


    @Override
    public List<LetterVO> selectLetter(String memberName) {
        return sqlSession.selectList("letterMapper.selectLetter",memberName);
    }

    @Override
    public void deleteLetter(LetterVO letterVO) {
        sqlSession.delete("letterMapper.deleteLetter",letterVO);
    }

    @Override
    public List<LetterVO> letterCnt() {
        return null;
    }
}
