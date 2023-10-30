package com.green.GreenClassRoom.room.controller;

import com.green.GreenClassRoom.board.vo.FreeBoardVO;
import com.green.GreenClassRoom.member.vo.MemberVO;
import com.green.GreenClassRoom.room.service.TodoService;
import com.green.GreenClassRoom.room.vo.TodoVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/room")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    // todo리스트 등록
    @GetMapping("/insertTodo")
    public String insertTodo(TodoVO todoVO, MemberVO memberVO, HttpSession session, Model model){
        MemberVO loginInfo=(MemberVO) session.getAttribute("loginInfo");
        todoVO.setTodoWriter(loginInfo.getMemberId());
        model.addAttribute("loginInfo",loginInfo);
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
