package com.green.GreenClassRoom.room.service;

import com.green.GreenClassRoom.room.vo.CalenderVO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CalenderServiceImpl implements CalenderService{
    private final SqlSessionTemplate sqlSession;

    @Override
    public List<CalenderVO> selectCalender() {
        return sqlSession.selectList("calenderMapper.selectCalender");
    }

    @Override
    public void insertCalender(CalenderVO calenderVO) {
        sqlSession.insert("calenderMapper.insertCalender", calenderVO);
    }
}
