package com.green.GreenClassRoom.member.service;

import com.green.GreenClassRoom.member.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(rollbackFor = Exception.class)
    public MemberVO selectLoginInfo(String memberId) {
        return sqlSession.selectOne("memberMapper.selectLoginInfo",memberId);
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
    public MemberVO loginInfo(String memberId) {
        return sqlSession.selectOne("memberMapper.loginInfo", memberId);
    }


}
