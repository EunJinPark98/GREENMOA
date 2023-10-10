package com.green.GreenClassRoom;

import com.green.GreenClassRoom.member.service.MemberService;
import com.green.GreenClassRoom.member.vo.MemberVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {
    final private MemberService memberService;

    @GetMapping("/")
    public String index(MemberVO memberVO, HttpSession session){
        MemberVO loginInfo=memberService.login(memberVO);
        if(loginInfo!=null) {
            session.setAttribute("loginInfo", loginInfo);
        }
        return "redirect:/room/main";
    }
}
