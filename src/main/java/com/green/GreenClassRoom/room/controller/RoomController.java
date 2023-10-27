package com.green.GreenClassRoom.room.controller;

import com.green.GreenClassRoom.member.service.MemberService;
import com.green.GreenClassRoom.member.vo.MemberVO;
import com.green.GreenClassRoom.room.service.RoomService;
import com.green.GreenClassRoom.room.service.TodoService;
import com.green.GreenClassRoom.room.service.WorkService;
import com.green.GreenClassRoom.room.vo.LetterVO;
import com.green.GreenClassRoom.room.vo.WorkVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {
    private final MemberService memberService;
    private final TodoService todoService;
    private final RoomService roomService;
    private final WorkService workService;

    //클래스룸
    @GetMapping("/main")
    public String main(Model model, HttpSession session, MemberVO memberVO, LetterVO letterVO) {

        model.addAttribute("memberList", memberService.selectMemberList());
        model.addAttribute("teacher", memberService.selectAdmin());

        MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
        model.addAttribute("loginInfo", loginInfo);

        model.addAttribute("workList", workService.selectWorkList());


        return "/content/room/main";
    }

    //마이룸
    @GetMapping("/myRoom")
    public String myRoom(Model model, HttpSession session, MemberVO memberVO, LetterVO letterVO) {
        MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
        String memberId = loginInfo.getMemberId();
        model.addAttribute("todoList", todoService.selectTodo(memberId));
        MemberVO statusMsg = roomService.selectStatusMsg(memberId);
        model.addAttribute("statusMsg", statusMsg);
        System.out.println("$$$$$$$" + statusMsg);
        model.addAttribute("loginInfo", loginInfo);

        String memberRoll=loginInfo.getMemberRoll();
        model.addAttribute("memberRoll",memberRoll);

        // 쪽지 리스트 출력 기능
        MemberVO loginInfo1 = (MemberVO) session.getAttribute("loginInfo");
        String memberId1 = loginInfo1.getMemberId();
        model.addAttribute("letterList", roomService.selectLetter(memberId1));

        // 쪽지 갯수 출력 기능 추가
        List<LetterVO> letterList = roomService.selectLetter(memberId);
        model.addAttribute("letterList", letterList);
        int letterCount = letterList.size();
        model.addAttribute("letterCount", letterCount);


        return "content/room/myRoom";
    }

    //쪽지 보내기 등록
    @PostMapping("/insertLetter")
    public String insertLetter(LetterVO letterVO, HttpSession session, Model model) {
        MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
        letterVO.setFromId(loginInfo.getMemberId());
        System.out.println("테이블함쌓을거야@@@@@@" + letterVO);

        roomService.insertLetter(letterVO);
        return "redirect:/room/main";
    }
    // 답장 보내기
    @PostMapping("/sendLetter")
    public String sendLetter(LetterVO letterVO, HttpSession session, Model model) {
        roomService.insertLetter(letterVO);
        return "redirect:/room/myRoom";
    }

    // 쪽지 선택 삭제
    @GetMapping("/deleteLetter")
    public String deleteLetter(@RequestParam(name = "letterNums") List<String> letterNums, LetterVO letterVO) {
        System.out.println(letterNums);
        letterVO.setLetterNumList(letterNums);
        roomService.deleteLetter(letterVO);
        return "redirect:/room/myRoom";
    }

    // 상태 메세지 수정 기능
    @GetMapping("/updateStatusMsg")
    public String updateStatusMsg(MemberVO memberVO) {
        roomService.updateStatusMsg(memberVO);
        System.out.println("########" + memberVO);
        return "redirect:/room/myRoom";
    }
    // 과제 등록 기능
    @PostMapping("/insertWork")
    public String insertWork(WorkVO workVO) {
        workService.insertWork(workVO);
        return "redirect:/room/myRoom";
    }




}






