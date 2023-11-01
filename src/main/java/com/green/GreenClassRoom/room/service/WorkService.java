package com.green.GreenClassRoom.room.service;

import com.green.GreenClassRoom.room.vo.WorkVO;

import java.util.List;

public interface WorkService {
    //과제 등록
    public void insertWork(WorkVO workVO);

    //과제 보기
    public List<WorkVO> selectWorkList();

    // 과제 삭제
    public void deleteWork(int workNum);
}
