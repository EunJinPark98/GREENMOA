package com.green.GreenClassRoom.member.controller;

import com.green.GreenClassRoom.member.service.MemberService;
import com.green.GreenClassRoom.member.vo.MemberVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    //회원가입 페이지
    @GetMapping("/joinPage")
    public String joinPage(){
        return "/content/member/join_page";
    }

    //로그인 성공 후 실행되는 메소드
    @GetMapping("/loginResult")
    public String loginResult(){
        return "/content/member/login_result";
    }

    //로그인 실패 후 실행되는 메소드
    @GetMapping("/loginFailResult")
    public String loginFailResult(){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@");
        return "/content/member/login_fail_result";
    }

    //회원가입
    @ResponseBody
    @PostMapping("/join")
    public void join(MemberVO memberVO){
    //public void join(@RequestBody Map<String, Object> map){
        System.out.println(memberVO);
        //System.out.println(map);
        String encodedPw = passwordEncoder.encode(memberVO.getMemberPw());
        memberVO.setMemberPw(encodedPw);

        memberService.join(memberVO);
    }

    //아이디 중복 확인
    @ResponseBody
    @PostMapping("/checkIdFetch")
    public boolean checkId(String memberId){
        return memberService.checkId(memberId);
    }


    // 로그인 페이지로
    @GetMapping("/loginPage")
    public String loginPage(){
        return "/content/member/login_page";
    }

}
