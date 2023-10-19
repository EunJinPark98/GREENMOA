package com.green.GreenClassRoom.room.controller;

import com.green.GreenClassRoom.member.service.MemberService;
import com.green.GreenClassRoom.member.vo.MemberVO;
import com.green.GreenClassRoom.room.service.RoomService;
import com.green.GreenClassRoom.room.service.TodoService;
import com.green.GreenClassRoom.room.vo.TodoVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Member;
import java.util.List;

@Controller
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {
    private final MemberService memberService;
    private final TodoService todoService;
    private final RoomService roomService;

    //클래스룸
    @GetMapping("/main")
    public String main(Model model){
        model.addAttribute("memberList", memberService.selectMemberList());
        model.addAttribute("teacher", memberService.selectAdmin());
        return "/content/room/main";
    }

    //마이룸
    @GetMapping("/myRoom")
    public String myRoom(Model model, HttpSession session,MemberVO memberVO){
        MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
        String memberId = loginInfo.getMemberId();
        model.addAttribute("todoList", todoService.selectTodo(memberId));
        return "content/room/myRoom";
    }

    // 상태 메세지 수정 기능
    @GetMapping("/updateStatusMsg")
    public String updateStatusMsg(MemberVO memberVO){
        roomService.updateStatusMsg(memberVO);
        System.out.println("########"+memberVO);
        return "redirect:/room/myRoom";
    }

}
