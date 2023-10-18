package com.green.GreenClassRoom.member.service;

import com.green.GreenClassRoom.member.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final SqlSessionTemplate sqlSession;

    @Override
    public int join(MemberVO memberVO) {
        return sqlSession.insert("memberMapper.join", memberVO);
    }

    @Override
    public boolean checkId(String memberId) {
        String selectMemberId = sqlSession.selectOne("memberMapper.checkId", memberId);
        return selectMemberId == null ? true : false;
    }

    @Override
    public MemberVO login(MemberVO memberVO) {
        return sqlSession.selectOne("memberMapper.login",memberVO);
    }

    @Override
    public List<MemberVO> selectMemberList() {
        return sqlSession.selectList("memberMapper.selectMemberList");
    }

    @Override
    public MemberVO selectAdmin() {
        return sqlSession.selectOne("memberMapper.selectAdmin");
    }

    @Override
    public int updateStatusMsg(MemberVO memberVO) {
        return sqlSession.update("memberMapper.updateStatusMsg",memberVO);
    }
}
