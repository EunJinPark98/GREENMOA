package com.green.GreenClassRoom.room.controller;

import com.green.GreenClassRoom.board.vo.FreeBoardVO;
import com.green.GreenClassRoom.member.service.MemberService;
import com.green.GreenClassRoom.member.vo.MemberVO;
import com.green.GreenClassRoom.room.service.RoomService;
import com.green.GreenClassRoom.room.service.TodoService;
import com.green.GreenClassRoom.room.vo.LetterVO;
import com.green.GreenClassRoom.room.vo.TodoVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Member;
import java.util.List;

@Controller
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {
    private final MemberService memberService;
    private final TodoService todoService;
    private final RoomService roomService;

    //클래스룸
    @GetMapping("/main")
    public String main(Model model, HttpSession session,MemberVO memberVO,LetterVO letterVO){
        model.addAttribute("memberList", memberService.selectMemberList());
        model.addAttribute("teacher", memberService.selectAdmin());

        MemberVO loginInfo=(MemberVO) session.getAttribute("loginInfo");
        model.addAttribute("loginInfo",loginInfo);
        System.out.println("######"+loginInfo);

        return "/content/room/main";
    }

    //마이룸
    @GetMapping("/myRoom")
    public String myRoom(Model model, HttpSession session,MemberVO memberVO, LetterVO letterVO){
        MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
        String memberId = loginInfo.getMemberId();
        model.addAttribute("todoList", todoService.selectTodo(memberId));
        MemberVO statusMsg =roomService.selectStatusMsg(memberId);
        model.addAttribute("statusMsg",statusMsg);
        System.out.println("$$$$$$$"+statusMsg);

        // 쪽지 리스트 출력 기능
        MemberVO loginInfo1 = (MemberVO) session.getAttribute("loginInfo");
        String memberName = loginInfo1.getMemberName();
        model.addAttribute("letterList", roomService.selectLetter(memberName));

        // 쪽지 갯수 출력 기능 추가
        List<LetterVO> letterList = roomService.selectLetter(memberName);
        model.addAttribute("letterList", letterList);
        int letterCount = letterList.size();
        model.addAttribute("letterCount", letterCount);

        return "content/room/myRoom";
    }

    //쪽지 보내기 등록
    @PostMapping("/insertLetter")
    public String insertLetter(LetterVO letterVO,HttpSession session,Model model){
        MemberVO loginInfo=(MemberVO) session.getAttribute("loginInfo");
        letterVO.setMemberId(loginInfo.getMemberId());
        roomService.insertLetter(letterVO);
        System.out.println("@#@#@#@#"+letterVO);
        return "redirect:/room/main";
    }

    // 쪽지 선택 삭제
    @GetMapping("/deleteLetter")
    public String deleteLetter(@RequestParam(name = "letterNums") List<String> letterNums, LetterVO letterVO){
        System.out.println(letterNums);
        letterVO.setLetterNumList(letterNums);
        roomService.deleteLetter(letterVO);
        return "redirect:/room/myRoom";
    }

    // 상태 메세지 수정 기능
    @GetMapping("/updateStatusMsg")
    public String updateStatusMsg(MemberVO memberVO){
        roomService.updateStatusMsg(memberVO);
        System.out.println("########"+memberVO);
        return "redirect:/room/myRoom";
    }





















}
