package com.green.GreenClassRoom.board.controller;

import com.green.GreenClassRoom.board.service.BookMarkService;
import com.green.GreenClassRoom.board.vo.BookMarkVO;
import com.green.GreenClassRoom.board.vo.QnaBoardVO;
import com.green.GreenClassRoom.member.vo.MemberVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookMarkController {
    private final BookMarkService bookMarkService;

    @ResponseBody
    @PostMapping("/insertBookMark")
    public int insertBookMark(BookMarkVO bookMarkVO, HttpSession session){
        MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
        bookMarkVO.setMemberId(loginInfo.getMemberId());

        return bookMarkService.insertBookMark(bookMarkVO);
    }

    @ResponseBody
    @PostMapping("/deleteBookMark")
    public int deleteBookMark(BookMarkVO bookMarkVO, HttpSession session){
        MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
        bookMarkVO.setMemberId(loginInfo.getMemberId());
        bookMarkVO.setBookMarkNum(bookMarkVO.getBookMarkNum());

        return bookMarkService.deleteBookMark(bookMarkVO);
    }
}
