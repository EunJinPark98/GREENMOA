package com.green.GreenClassRoom.board.controller;

import com.green.GreenClassRoom.board.service.QnaBoardService;
import com.green.GreenClassRoom.board.vo.QnaBoardVO;
import com.green.GreenClassRoom.board.vo.QnaReplyVO;
import com.green.GreenClassRoom.member.vo.MemberVO;
import com.green.GreenClassRoom.util.ConstantVariable;
import com.green.GreenClassRoom.util.UploadUtil;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

        //페이징 처리
        int totalDataCnt = qnaBoardService.selectQnaBoardCnt();
        qnaBoardVO.setTotalDataCnt(totalDataCnt);
        qnaBoardVO.setPageInfo();

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
    public String qnaBoardDetail(int qnaBoardNum, Model model, QnaReplyVO qnaReplyVO,
                                 @RequestParam(required = false, defaultValue = "false") boolean noCount,
                                 HttpSession session, QnaBoardVO qnaBoardVO){

        MemberVO loginInfo=(MemberVO) session.getAttribute("loginInfo");
        qnaBoardVO.setQnaBoardWriter(loginInfo.getMemberId());
        model.addAttribute("loginInfo",loginInfo);

        QnaBoardVO qnaBoard = qnaBoardService.qnaBoardDetail(qnaBoardNum);
        model.addAttribute("qnaBoardList", qnaBoard);

        // @RequestParam(required = false, defaultValue = "false") boolean noCount
        // 댓글 등록이 실행되지 않으면 noCount가 넘어오지 않고, 그 값은 false가 된다.
        // 댓글 등록 시 게시글 목록 페이지로 오면 카운터 무효!
        // noCount 가 true가 아니라면 페이지의 조회수가 올라간다.
        if(!noCount){
            qnaBoardService.updateCnt(qnaBoardNum);
        }

        List<QnaReplyVO> qnaReplyList = qnaBoardService.selectQnaReply(qnaReplyVO);
        model.addAttribute("qnaReplyList", qnaReplyList);
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
            //첨부파일이 존재하지 않는 게시글을 수정?
            //디비는 update
            //첨부파일을 추가(게시글 등록때처럼 똑같이)

            QnaBoardVO upLoadInfo = UploadUtil.uploadFile(img);
            //이미지 파일을 첨부시 원본 파일명과 첨부된 파일명 데이터를 가져오는것!
            if (upLoadInfo != null){
                qnaBoardVO.setOriginFileName(upLoadInfo.getOriginFileName());
                qnaBoardVO.setAttachedFileName(upLoadInfo.getAttachedFileName());

            }
        }
        //첨부파일 수정도 안하고 게시글만 삭제할때
        if(qnaBoard.getAttachedFileName() == null){}

        qnaBoardService.updateQnaBoard(qnaBoardVO);

        if(qnaBoard.getAttachedFileName() == null){

        }
        //첨부파일이 존재하지 않는 게시글을 수정?
        //디비는 update
        //첨부파일을 추가(게시글 등록때처럼 똑같이)
        System.out.println("!!!!!!!!!!!!" + qnaBoardVO);
        //qnaBoardService.updateFile(qnaBoardVO);
       // qnaBoardService.updateQnaBoard(qnaBoardVO);
        return "redirect:/board/qnaBoardDetail?qnaBoardNum=" + qnaBoardVO.getQnaBoardNum();
    }

    //질문게시판 첨부파일 삭제
    @GetMapping("/deleteFile")
    public String deleteFile(QnaBoardVO qnaBoardVO){
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

    // 답변 작성
    @PostMapping("/insertQnaReply")
    public String insertReply(QnaReplyVO qnaReplyVO){

        qnaBoardService.insertQnaReply(qnaReplyVO);
        //+ "&noCount=true" :  댓글 작성시 조회수가 오르지 않게 하기 위해 true인 값인 noCount를 보낸다.
        return "redirect:/board/qnaBoardDetail?qnaBoardNum=" + qnaReplyVO.getQnaBoardNum() + "&replyer=" + qnaReplyVO.getQnaReplyer() + "&noCount=true" ;
    }

    // 답변 삭제 기능
    @RequestMapping("/deleteQnaReply")
    public String deleteReply(QnaReplyVO qnaReplyVO){
        qnaReplyVO.setQnaReplyNum(qnaReplyVO.getQnaReplyNum());
        qnaBoardService.deleteQnaReply(qnaReplyVO);
        return "redirect:/board/qnaBoardDetail?qnaBoardNum=" + qnaReplyVO.getQnaBoardNum() + "&replyer=" + qnaReplyVO.getQnaReplyer() + "&noCount=true";
    }

}
