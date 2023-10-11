package com.green.GreenClassRoom.board.controller;

import com.green.GreenClassRoom.board.service.QnaBoardService;
import com.green.GreenClassRoom.board.vo.QnaBoardVO;
import com.green.GreenClassRoom.member.vo.MemberVO;
import com.green.GreenClassRoom.util.UploadUtil;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class QnaBoardController {
    private final QnaBoardService qnaBoardService;

    //질문게시판 페이지
    @RequestMapping("/question")
    public String qnaBoardList(QnaBoardVO qnaBoardVO, Model model){

        //질문게시판 글 조회
        List<QnaBoardVO> qnaBoardList = qnaBoardService.selectQnaBoard(qnaBoardVO);
        model.addAttribute("qnaBoardList", qnaBoardList);
        return "content/board/qna_board_list";
    }

    //질문게시판 글쓰기 페이지
    @GetMapping("/qnaBoardUpdatePage")
    public String qnaBoardUpdatePage(){
        return "content/board/qna_board_insert_page";
    }

    //질문게시판 글 작성
    @PostMapping("/qnaBoardInsert")
    public String qnaBoardInsert(QnaBoardVO qnaBoardVO, MultipartFile img, HttpSession session){
        //이미지 파일 첨부
        QnaBoardVO upLoadInfo = UploadUtil.uploadFile(img);
        //이미지 파일을 첨부시 원본 파일명과 첨부된 파일명 데이터를 가져오는것!
        if (upLoadInfo != null){
            qnaBoardVO.setOriginFileName(upLoadInfo.getOriginFileName());
            qnaBoardVO.setAttachedFileName(upLoadInfo.getAttachedFileName());
        }
        MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
        qnaBoardVO.setQnaBoardWriter(loginInfo.getMemberId());
        qnaBoardService.insert(qnaBoardVO);
        return "redirect:/board/question";
    }

    //질문게시판 상세페이지
    @GetMapping("/qnaBoardDetail")
    public String qnaBoardDetail(int qnaBoardNum, Model model){
        //게시글 조회수 증가
        qnaBoardService.updateCnt(qnaBoardNum);

        QnaBoardVO qnaBoard = qnaBoardService.qnaBoardDetail(qnaBoardNum);
        model.addAttribute("qnaBoardList", qnaBoard);
        return "content/board/qna_board_detail";
    }

    //질문게시판 삭제
    @GetMapping("/deleteQnaBoard")
    public String deleteBoard(int qnaBoardNum){
        qnaBoardService.deleteQnaBoard(qnaBoardNum);
        return "redirect:/board/question";
    }

    //질문게시판 수정 페이지
    @GetMapping("/updateQnaBoardPage")
    public String updateQnaBoardPage(int qnaBoardNum, Model model){
        QnaBoardVO qnaBoardDetail = qnaBoardService.qnaBoardDetail(qnaBoardNum);
        model.addAttribute("qnaBoardDetail", qnaBoardDetail);
        return "/content/board/qna_board_update_page";
    }

    //질문게시판 수정
    @PostMapping("/updateQnaBoard")
    public String updateQnaBoard(QnaBoardVO qnaBoardVO){
        qnaBoardService.updateQnaBoard(qnaBoardVO);
        return "redirect:/board/qnaBoardDetail?qnaBoardNum=" + qnaBoardVO.getQnaBoardNum();
    }


}
