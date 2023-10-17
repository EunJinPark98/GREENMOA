package com.green.GreenClassRoom.room.controller;

import com.green.GreenClassRoom.member.service.MemberService;
import com.green.GreenClassRoom.member.vo.MemberVO;
import com.green.GreenClassRoom.room.service.TodoService;
import com.green.GreenClassRoom.room.vo.TodoVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Member;

@Controller
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {
    private final MemberService memberService;
    private final TodoService todoService;

    //클래스룸
    @GetMapping("/main")
    public String main(Model model){
        model.addAttribute("memberList", memberService.selectMemberList());
        return "/content/room/main";
    }

    //마이룸
    @GetMapping("/myRoom")
    public String myRoom(Model model, HttpSession session){
        MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
        String memberId = loginInfo.getMemberId();
        model.addAttribute("todoList", todoService.selectTodo(memberId));
        return "content/room/myRoom";
    }

}
