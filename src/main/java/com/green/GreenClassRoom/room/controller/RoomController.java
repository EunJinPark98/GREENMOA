package com.green.GreenClassRoom.room.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {
//여기는 메인 화면 작업하는 컨트롤러입니다!!
    @GetMapping("/main")
    public String main(){
        return "/content/room/main";
    }

}
