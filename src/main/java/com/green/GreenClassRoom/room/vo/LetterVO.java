package com.green.GreenClassRoom.room.vo;

import lombok.Data;

import java.util.List;

@Data
public class LetterVO {
    private int letterNum;
    private String fromId;
    private String memberId;
    private String letterContent;
    private String letterDate;
    private List<String> letterNumList;
    private int letterCount;
}
