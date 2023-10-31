package com.green.GreenClassRoom.member.controller;

import com.green.GreenClassRoom.member.service.MemberService;
import com.green.GreenClassRoom.member.vo.MemberVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    //회원가입 페이지
    @GetMapping("/joinPage")
    public String joinPage(){
        return "/content/member/join_page";
    }

    //회원가입
    @ResponseBody
    @PostMapping("/join")
    public void join(MemberVO memberVO){
    //public void join(@RequestBody Map<String, Object> map){
        System.out.println(memberVO);
        //System.out.println(map);
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

    // 로그인 기능
    @PostMapping("/login")
    public String login(MemberVO memberVO, HttpSession session){
        MemberVO loginInfo=memberService.login(memberVO);
        if(loginInfo!=null) {
            session.setAttribute("loginInfo", loginInfo);
        }


        return "/content/member/login_result";
    }
    // 로그아웃 기능
    @GetMapping("/logout")
    public String logout(HttpSession session){
        MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
        session.removeAttribute("loginInfo");
        return "redirect:/room/main";
    }



}
