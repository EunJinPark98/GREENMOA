package com.green.GreenClassRoom.board.controller;

import com.green.GreenClassRoom.board.service.QnaBoardService;
import com.green.GreenClassRoom.board.vo.QnaBoardVO;
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
public class QnaBoardController {
    private final QnaBoardService qnaBoardService;

    //질문게시판 페이지
    @RequestMapping("/question")
    public String qnaBoardList(QnaBoardVO qnaBoardVO, Model model){

        //질문게시판 글 조회
        List<QnaBoardVO> qnaBoardList = qnaBoardService.selectQnaBoard(qnaBoardVO);
        model.addAttribute("qnaBoardList", qnaBoardList);
        return "content/board/qna_board_list";
    }

    //질문게시판 글쓰기 페이지
    @GetMapping("/qnaBoardUpdatePage")
    public String qnaBoardUpdatePage(){
        return "content/board/qna_board_insert_page";
    }

    //질문게시판 글 작성
    @PostMapping("/qnaBoardInsert")
    public String qnaBoardInsert(QnaBoardVO qnaBoardVO){
        qnaBoardService.insert(qnaBoardVO);
        return "redirect:/board/question";
    }

}
