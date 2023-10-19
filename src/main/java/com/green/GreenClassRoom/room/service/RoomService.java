package com.green.GreenClassRoom.room.service;

import com.green.GreenClassRoom.member.vo.MemberVO;
import com.green.GreenClassRoom.room.vo.menuVO;

import java.util.List;

public interface RoomService {
    public List<menuVO> selectMenuList();

    // 상태 메세지 수정 기능
    public int updateStatusMsg(MemberVO memberVO);
}
