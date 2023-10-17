package com.green.GreenClassRoom.board.controller;

import com.green.GreenClassRoom.board.service.NoticeBoardService;
import com.green.GreenClassRoom.board.vo.NoticeBoardVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class NoticeBoardController {
    private final NoticeBoardService noticeBoardService;

    // 공지사항 목록 첫페이지
    @RequestMapping("/notice")
    public String noticeList(NoticeBoardVO noticeBoardVO, Model model){
        List<NoticeBoardVO> noticeList = noticeBoardService.selectNoticeList(noticeBoardVO);
        model.addAttribute("noticeList", noticeList);
        return "/content/board/notice_board_list";
    }

    // 공지사항 글쓰기 페이지 이동
    @GetMapping("/noticeBoardWrite")
    public String noticeBoardWrite(){
        return "content/board/notice_board_write";
    }
}
