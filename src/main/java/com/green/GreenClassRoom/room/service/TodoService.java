package com.green.GreenClassRoom.room.service;

import com.green.GreenClassRoom.room.vo.TodoVO;

import java.util.List;

public interface TodoService {
    // todo리스트 등록
    public int insertTodo(TodoVO todoVO);
    // todo리스트 조회
    public List<TodoVO> selectTodo(String todoWriter);
    // todo리스트 삭제
    public void deleteTodoList(int todoNum);

}
