package com.green.GreenClassRoom.room.service;

import com.green.GreenClassRoom.room.vo.TodoVO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

    private final SqlSessionTemplate sqlSession;

    @Override
    public int insertTodo(TodoVO todoVO) {
        return sqlSession.insert("todoMapper.insertTodo",todoVO);
    }


    @Override
    public List<TodoVO> selectTodo(String todoWriter) {
        return sqlSession.selectList("todoMapper.selectTodo",todoWriter);
    }

    @Override
    public void deleteTodoList(int todoNum) {
        sqlSession.delete("todoMapper.deleteTodoList",todoNum);
    }

}
