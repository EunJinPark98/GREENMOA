package com.green.GreenClassRoom.room.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {

    //클래스룸
    @GetMapping("/main")
    public String main(){

        return "/content/room/main";
    }

    //마이룸
    @GetMapping("/myRoom")
    public String myRoom(){


        return "content/room/myRoom";
    }

}
