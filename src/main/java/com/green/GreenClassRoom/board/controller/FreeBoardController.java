package com.green.GreenClassRoom.board.controller;

import com.green.GreenClassRoom.board.service.FreeBoardService;
import com.green.GreenClassRoom.board.vo.FreeBoardVO;
import com.green.GreenClassRoom.member.vo.MemberVO;
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
        MemberVO loginInfo=(MemberVO) session.getAttribute("loginInfo");
        freeBoardVO.setWriter(loginInfo.getMemberId());
//        writer 값 임시로 지정
//        freeBoardVO.setWriter("test2");
        freeBoardService.insertFreeBoard(freeBoardVO);
        System.out.println("@@@@@@@@@@@@@"+freeBoardVO);
        return "redirect:/board/freeBoardList";
    }

    // 게시글 상세 페이지 이동, 게시글 조회수 증가 기능
    @GetMapping("/freeBoardDetail")
    public String freeBoardDetail(int boardNum,Model model){
        FreeBoardVO freeBoardDetail=freeBoardService.selectFreeBoardDetail(boardNum);
        model.addAttribute("freeBoardDetail",freeBoardDetail);

        freeBoardService.readCntUp(boardNum);
        return "content/board/free_board_detail";
    }
    // 게시글 수정 페이지 이동
    @GetMapping("/updateBoardForm")
    public String updateBoardForm(int boardNum,Model model){
        FreeBoardVO freeBoardDetail=freeBoardService.selectFreeBoardDetail(boardNum);
        model.addAttribute("freeBoardDetail",freeBoardDetail);
        return "content/board/free_board_update";
    }

    // 게시글 수정 기능
    @PostMapping("/updateFreeBoard")
    public String updateFreeBoard(FreeBoardVO freeBoardVO){
        freeBoardService.updateFreeBoard(freeBoardVO);
        return "redirect:/board/freeBoardDetail?boardNum="+freeBoardVO.getBoardNum();
    }

    // 게시글 삭제 기능
    @GetMapping("/deleteBoard")
    public String deleteBoard(int boardNum){
        freeBoardService.deleteFreeBoard(boardNum);
        return "redirect:/board/freeBoardList";
    }
}
