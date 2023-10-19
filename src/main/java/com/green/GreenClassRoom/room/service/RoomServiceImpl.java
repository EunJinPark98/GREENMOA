package com.green.GreenClassRoom.room.service;

import com.green.GreenClassRoom.member.vo.MemberVO;
import com.green.GreenClassRoom.room.vo.menuVO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService{
    private final SqlSessionTemplate sqlSession;

    @Override
    public List<menuVO> selectMenuList() {
        return sqlSession.selectList("menuMapper.selectMenuList");
    }

    @Override
    public int updateStatusMsg(MemberVO memberVO) {
        return sqlSession.update("memberMapper.updateStatusMsg",memberVO);
    }
}
