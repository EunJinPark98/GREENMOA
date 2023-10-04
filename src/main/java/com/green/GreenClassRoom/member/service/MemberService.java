package com.green.GreenClassRoom.member.service;

import com.green.GreenClassRoom.member.vo.MemberVO;

public interface MemberService {

    //회원가입
    public int join(MemberVO memberVO);

    //아이디 중복 확인
    public boolean checkId(String memberId);
}
