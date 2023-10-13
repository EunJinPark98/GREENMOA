package com.green.GreenClassRoom.room.controller;

import com.green.GreenClassRoom.member.vo.MemberVO;
import com.green.GreenClassRoom.room.service.TodoService;
import com.green.GreenClassRoom.room.vo.TodoVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/room")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    // todo리스트 등록
    @PostMapping("/insertTodo")
    @ResponseBody
    public void insertTodo(TodoVO todoVO, MemberVO memberVO, HttpSession session, Model model){
        MemberVO loginInfo=(MemberVO) session.getAttribute("loginInfo");
        todoVO.setTodoWriter(loginInfo.getMemberId());
        model.addAttribute("loginInfo",loginInfo);
        System.out.println("@@@@@@@"+todoVO);
        todoService.insertTodo(todoVO);
    }
}
