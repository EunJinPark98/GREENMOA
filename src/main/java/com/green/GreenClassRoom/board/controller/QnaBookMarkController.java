package com.green.GreenClassRoom.board.controller;

import com.green.GreenClassRoom.board.service.QnaBookMarkService;
import com.green.GreenClassRoom.board.vo.QnaBookMarkVO;
import com.green.GreenClassRoom.member.vo.MemberVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class QnaBookMarkController {
    private final QnaBookMarkService qnaBookMarkService;

    //북마크 추가ㅏ
    @ResponseBody
    @PostMapping("/insertBookMark")
    public int insertBookMark(QnaBookMarkVO qnaBookMarkVO, HttpSession session){
        MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
        qnaBookMarkVO.setMemberId(loginInfo.getMemberId());

        return qnaBookMarkService.insertBookMark(qnaBookMarkVO);
    }

    //북마크 삭제
    @ResponseBody
    @PostMapping("/deleteBookMark")
    public int deleteBookMark(QnaBookMarkVO qnaBookMarkVO, HttpSession session){
        MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
        qnaBookMarkVO.setMemberId(loginInfo.getMemberId());
        qnaBookMarkVO.setQnaBookMarkNum(qnaBookMarkVO.getQnaBookMarkNum());

        return qnaBookMarkService.deleteBookMark(qnaBookMarkVO);
    }
}
