package com.green.GreenClassRoom.board.controller;

import com.green.GreenClassRoom.board.service.FreeBoardService;
import com.green.GreenClassRoom.board.vo.FreeBoardVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class FreeBoardController {
    private final FreeBoardService freeBoardService;

    // 게시글 목록 페이지 이동
    @RequestMapping("/freeBoardList")
    public String freeBoardList(FreeBoardVO freeBoardVO, Model model){
        System.out.println("///////////////////////"+freeBoardVO);
        List< FreeBoardVO> boardList = freeBoardService.selectFreeBoardList(freeBoardVO);
        model.addAttribute("boardList",boardList);
        return "content/board/free_board_list";
    }

    // 게시글 작성 페이지 이동
    @GetMapping("/freeBoardWrite")
    public String boardWrite(){
        return "content/board/free_board_write";
    }

    // 게시글 작성
    @PostMapping("/insertFreeBoard")
    public String insertFreeBoard(FreeBoardVO freeBoardVO, HttpSession session){
//        FreeBoardVO loginInfo=(FreeBoardVO) session.getAttribute("loginInfo");
//        freeBoardVO.setWriter(loginInfo.getWriter());
        // writer 값 임시로 지정
        freeBoardVO.setWriter("test2");
        freeBoardService.insertFreeBoard(freeBoardVO);
        System.out.println("@@@@@@@@@@@@@"+freeBoardVO);
        return "redirect:/board/freeBoardList";
    }
}
