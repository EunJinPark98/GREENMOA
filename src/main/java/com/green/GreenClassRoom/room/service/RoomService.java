package com.green.GreenClassRoom.room.service;

import com.green.GreenClassRoom.member.vo.MemberVO;
import com.green.GreenClassRoom.room.vo.LetterVO;
import com.green.GreenClassRoom.room.vo.TodoVO;
import com.green.GreenClassRoom.room.vo.menuVO;

import java.util.List;

public interface RoomService {
    public List<menuVO> selectMenuList();

    // 상태 메세지 수정 기능
    public int updateStatusMsg(MemberVO memberVO);

    // 상태 메세지 출력
    public MemberVO selectStatusMsg(String memberId);

    // 쪽지 보내기 등록
    public void insertLetter(LetterVO letterVO);

    // 쪽지 확인
    public List<LetterVO> selectLetter(String memberId);

    // 쪽지 선택 삭제
    public void deleteLetter(LetterVO letterVO);

    // 쪽지 갯수 출력
    public List<LetterVO> letterCnt();
}
