package com.green.GreenClassRoom.board.controller;

import com.green.GreenClassRoom.board.service.NoticeBookMarkService;
import com.green.GreenClassRoom.board.vo.NoticeBookMarkVO;
import com.green.GreenClassRoom.member.vo.MemberVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class NoticeBookMarkController {
    private final NoticeBookMarkService noticeBookMarkService;

    //공지사항 북마크 등록
    @ResponseBody
    @PostMapping("insertNoticeBookMark")
    public int insertNoticeBookMark(NoticeBookMarkVO noticeBookMarkVO, Authentication authentication){
        User user = (User) authentication.getPrincipal();
        noticeBookMarkVO.setMemberId(user.getUsername());

        return noticeBookMarkService.insertNoticeBookMark(noticeBookMarkVO);
    }

    //공지사상 북마크 삭제
    @ResponseBody
    @PostMapping("/deleteNoticeBookMark")
    public int deleteNoticeBookMark(NoticeBookMarkVO noticeBookMarkVO, Authentication authentication){
        User user = (User) authentication.getPrincipal();
        noticeBookMarkVO.setMemberId(user.getUsername());
        noticeBookMarkVO.setNoticeBookMarkNum(noticeBookMarkVO.getNoticeBoardNum());

        return noticeBookMarkService.deleteNoticeBookMark(noticeBookMarkVO);
    }
}
