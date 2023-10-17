package com.green.GreenClassRoom.room.vo;

import lombok.Data;

import java.util.List;

@Data
public class TodoVO {
    private int todoNum;
    private String todoWriter;
    private String todoContent;
    private String todoStartDate;
    private String todoFinishDate;
    private String dDay;

}
