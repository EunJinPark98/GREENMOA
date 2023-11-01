package com.green.GreenClassRoom.room.controller;

import com.green.GreenClassRoom.board.vo.FreeBoardVO;
import com.green.GreenClassRoom.member.service.MemberService;
import com.green.GreenClassRoom.member.vo.MemberVO;
import com.green.GreenClassRoom.room.service.TodoService;
import com.green.GreenClassRoom.room.vo.TodoVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/room")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;
    private final MemberService memberService;

    // todo리스트 등록
    @GetMapping("/insertTodo")
    public String insertTodo(TodoVO todoVO, MemberVO memberVO, Model model, Authentication authentication){
        User user = (User)authentication.getPrincipal();


        todoVO.setTodoWriter(user.getUsername());
        model.addAttribute("loginInfo", memberService.selectLoginInfo(user.getUsername()));
        System.out.println("@@@@@@@"+todoVO);
        todoService.insertTodo(todoVO);

        return "redirect:/room/myRoom";
    }
    // 투두 선택 삭제
    @GetMapping("/deleteTodoList")
    public String deleteTodoList(int todoNum, TodoVO todoVO){
        System.out.println("@@@@@"+todoNum);

        // 선택 투두 삭제
        todoService.deleteTodoList(todoNum);
        return "redirect:/room/myRoom";
    }

}
