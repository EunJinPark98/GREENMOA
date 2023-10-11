package com.green.GreenClassRoom;

import com.green.GreenClassRoom.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {
    final private MemberService memberService;

    @GetMapping("/")
    public String index(){

        return "redirect:/room/main";
    }
}
