package com.green.GreenClassRoom.board.controller;

import com.green.GreenClassRoom.board.service.NoticeBoardService;
import com.green.GreenClassRoom.board.vo.NoticeBoardVO;
import com.green.GreenClassRoom.member.vo.MemberVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.NodeList;

import java.util.List;
import java.util.Map;

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

        int totalDataCnt = noticeBoardService.pagingNotice();
        noticeBoardVO.setTotalDataCnt(totalDataCnt);
        noticeBoardVO.setPageInfo();
        return "/content/board/notice_board_list";
    }

    // 공지사항 글쓰기 페이지 이동
    @GetMapping("/noticeBoardWrite")
    public String noticeBoardWrite(){
        return "content/board/notice_board_write";
    }

    // 글작성
    @PostMapping("/insertNotice")
    public String insertNotice(NoticeBoardVO noticeBoardVO, HttpSession session){
        MemberVO loginInfo = (MemberVO)session.getAttribute("loginInfo");
        noticeBoardVO.setMemberId(loginInfo.getMemberId());
        noticeBoardService.insertNotice(noticeBoardVO);
        return "redirect:/board/notice";
    }

    // 상세페이지
    @GetMapping("/noticeBoardDetail")
    public String noticeBoardDetail(int noticeBoardNum, Model model){
        noticeBoardService.updateReadCnt(noticeBoardNum);

        NoticeBoardVO noticeInfo = noticeBoardService.noticeBoardDetail(noticeBoardNum);
        model.addAttribute("noticeInfo", noticeInfo);

        NoticeBoardVO prevList = noticeBoardService.prevList(noticeBoardNum);
        int nextList = noticeBoardService.nextList(noticeBoardNum);
        model.addAttribute("prevNum", prevList.getNoticeBoardNum());
        model.addAttribute("prevTitle", prevList.getNoticeBoardTitle());
        model.addAttribute("nextNum",nextList);
        System.out.println("pl"+prevList);
        return "content/board/notice_board_detail";
    }

    // 공지 삭제
    @GetMapping("/deleteNotice")
    public String deleteNotice(int noticeBoardNum){
        noticeBoardService.deleteNotice(noticeBoardNum);
        return "redirect:/board/notice";
    }

    // 수정 페이지 이동
    @GetMapping("/updateNoticeForm")
    public String updateNoticeForm(int noticeBoardNum, Model model){
        NoticeBoardVO noticeInfo = noticeBoardService.noticeBoardDetail(noticeBoardNum);
        model.addAttribute("noticeInfo", noticeInfo);
        return "content/board/notice_board_update_page";
    }

    // 공지 수정
    @PostMapping("/updateNotice")
    public String updateNotice(NoticeBoardVO noticeBoardVO){
        noticeBoardService.updateNotice(noticeBoardVO);
        return "redirect:/board/noticeBoardDetail?noticeBoardNum=" + noticeBoardVO.getNoticeBoardNum();
    }
}
