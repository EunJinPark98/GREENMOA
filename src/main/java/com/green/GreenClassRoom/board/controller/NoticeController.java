package com.green.GreenClassRoom.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class NoticeController {

    @GetMapping("/notice")
    public String notice(){
        return "/content/board/notice_board_list";
    }
}
