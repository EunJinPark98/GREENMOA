package com.green.GreenClassRoom.room.service;

import com.green.GreenClassRoom.room.vo.CalenderVO;

import java.util.List;

public interface CalenderService {

    //캘린더 조회
    public List<CalenderVO> selectCalender();

    //캘린더 일정 추가
    public void insertCalender(CalenderVO calenderVO);
}
