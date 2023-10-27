package com.green.GreenClassRoom.member.vo;

import lombok.Data;

@Data
public class MemberVO {
    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberBirthday;
    private String memberGender;
    private String memberTel;
    private String[] memberTels;
    private String memberAddr;
    private String addrDetail;
    private String memberEmail;
    private String[] memberEmails;
    private String memberRoll;
    private String minime;
    private String statusMsg;

}
