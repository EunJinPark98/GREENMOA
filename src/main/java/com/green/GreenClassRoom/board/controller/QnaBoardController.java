package com.green.GreenClassRoom.board.controller;

import com.green.GreenClassRoom.board.service.QnaBoardService;
import com.green.GreenClassRoom.board.vo.QnaBoardVO;
import com.green.GreenClassRoom.board.vo.ReplyVO;
import com.green.GreenClassRoom.member.vo.MemberVO;
import com.green.GreenClassRoom.util.ConstantVariable;
import com.green.GreenClassRoom.util.UploadUtil;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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
    public String qnaBoardDetail(int qnaBoardNum, Model model, ReplyVO replyVO){
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
    @RequestMapping("/updateQnaBoard")
    public String updateQnaBoard(QnaBoardVO qnaBoardVO, MultipartFile img){
        //수정하려는 게시글에 첨부파일 존재 여부 확인

        QnaBoardVO qnaBoard = qnaBoardService.qnaBoardDetail(qnaBoardVO.getQnaBoardNum());
        if (qnaBoard.getAttachedFileName() != null){

            //첨부파일이 존재하는 게시글을 수정?
            //디비는 update
            //첨부파일은 삭제 후 등록
            if (qnaBoard.getAttachedFileName() != null){
                String imgPath = ConstantVariable.UPLOAD_PATH;

                if (imgPath != null){
                    File imgFile = new File(imgPath + qnaBoard.getAttachedFileName());
                    if (imgFile.exists()){
                        imgFile.delete();
                    }
                }
                QnaBoardVO upLoadInfo = UploadUtil.uploadFile(img);
                //이미지 파일을 첨부시 원본 파일명과 첨부된 파일명 데이터를 가져오는것!
                if (upLoadInfo != null){
                    qnaBoardVO.setOriginFileName(upLoadInfo.getOriginFileName());
                    qnaBoardVO.setAttachedFileName(upLoadInfo.getAttachedFileName());
                }
            }

        }
        if (qnaBoard.getAttachedFileName() == null){

            System.out.println("dkdkdkkdsfjlkejf;oisjekl아아ㅏ아아아ㅏㅇ");
            QnaBoardVO upLoadInfo = UploadUtil.uploadFile(img);
            //이미지 파일을 첨부시 원본 파일명과 첨부된 파일명 데이터를 가져오는것!
            if (upLoadInfo != null){
                qnaBoardVO.setOriginFileName(upLoadInfo.getOriginFileName());
                qnaBoardVO.setAttachedFileName(upLoadInfo.getAttachedFileName());

                qnaBoardService.updateQnaBoard(qnaBoardVO);
            }
        }

        //첨부파일이 존재하지 않는 게시글을 수정?
        //디비는 update
        //첨부파일을 추가(게시글 등록때처럼 똑같이)

        return "redirect:/board/qnaBoardDetail?qnaBoardNum=" + qnaBoardVO.getQnaBoardNum();
    }

    //질문게시판 첨부파일 삭제
    @GetMapping("/updateFile")
    public String updateFile(QnaBoardVO qnaBoardVO){
        QnaBoardVO qnaBoard = qnaBoardService.qnaBoardDetail(qnaBoardVO.getQnaBoardNum());

        if (qnaBoard.getAttachedFileName() != null){
            String imgPath = ConstantVariable.UPLOAD_PATH;

            if (imgPath != null){
                File imgFile = new File(imgPath + qnaBoard.getAttachedFileName());
                if (imgFile.exists()){
                    imgFile.delete();
                }
            }
        }

        qnaBoardService.deleteFile(qnaBoardVO);
        return "redirect:/board/updateQnaBoardPage?qnaBoardNum=" + qnaBoardVO.getQnaBoardNum();
    }

//    // 댓글 작성
//    @PostMapping("/insertReply")
//    public String insertReply(ReplyVO replyVO){
//        qnaBoardService.insertReply(replyVO);
//        //+ "&noCount=true" :  댓글 작성시 조회수가 오르지 않게 하기 위해 true인 값인 noCount를 보낸다.
//        return "redirect:/board/qnaBoardDetail?QnaBoardNum="+replyVO.getBoardNum()+"&replyer="+replyVO.getReplyer() + "&noCount=true" ;
//    }
//
//    // 댓글 삭제 기능
//    @GetMapping("/deleteReply")
//    public String deleteReply(int replyNum,ReplyVO replyVO){
//        //replyVO.setReplyNumList(replyNums);
//        qnaBoardService.deleteReply(replyNum);
//        return "redirect:/board/qnaBoardDetail?QnaBoardNum="+replyVO.getBoardNum()+"&replyer="+replyVO.getReplyer() + "&noCount=true";
//    }

}
