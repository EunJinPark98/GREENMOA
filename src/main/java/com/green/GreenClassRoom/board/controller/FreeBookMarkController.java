package com.green.GreenClassRoom.board.controller;

import com.green.GreenClassRoom.board.service.FreeBookMarkService;
import com.green.GreenClassRoom.board.vo.FreeBookMarkVO;
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
public class FreeBookMarkController {
    private final FreeBookMarkService freeBookMarkService;

    //북마크 추가
    @ResponseBody
    @PostMapping("/insertFreeBookMark")
    public int insertFreeBookMark(FreeBookMarkVO freeBookMarkVO, Authentication authentication){
        User user = (User) authentication.getPrincipal();
        freeBookMarkVO.setMemberId(user.getUsername());

        return freeBookMarkService.insertFreeBookMark(freeBookMarkVO);
    }

    //북마크 삭제
    @ResponseBody
    @PostMapping("/deleteFreeBookMark")
    public int deleteFreeBookMark(FreeBookMarkVO freeBookMarkVO, Authentication authentication){
        User user = (User) authentication.getPrincipal();
        freeBookMarkVO.setMemberId(user.getUsername());
        freeBookMarkVO.setFreeBookMarkNum(freeBookMarkVO.getFreeBookMarkNum());

        return freeBookMarkService.deleteFreeBookMark(freeBookMarkVO);
    }
}
