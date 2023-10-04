package com.green.GreenClassRoom.member.service;

import com.green.GreenClassRoom.member.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

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
}
