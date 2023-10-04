package com.green.GreenClassRoom.room.controller;

import com.green.GreenClassRoom.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @GetMapping("/main")
    public String main(Model model){
        model.addAttribute("menuList", roomService.selectMenuList());
        return "/content/room/main";
    }

}
