package com.green.GreenClassRoom.member.controller;

import com.green.GreenClassRoom.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    //회원가입 페이지
    @GetMapping("/joinPage")
    public String joinPage(){
        return "join_page";
    }

    //로그인 페이지
    @GetMapping("/loginPage")
    public String loginPage(){
        return "login_page";
    }
}
