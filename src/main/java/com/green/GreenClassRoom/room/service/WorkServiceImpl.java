package com.green.GreenClassRoom.room.service;

import com.green.GreenClassRoom.room.vo.WorkVO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkServiceImpl implements WorkService{
    private final SqlSessionTemplate sqlSession;


    @Override
    public void insertWork(WorkVO workVO) {
        sqlSession.insert("workMapper.insertWork", workVO);
    }

    @Override
    public List<WorkVO> selectWorkList() {
        return sqlSession.selectList("workMapper.selectWorkList");
    }
}
