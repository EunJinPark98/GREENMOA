package com.green.GreenClassRoom.room.controller;

import com.green.GreenClassRoom.room.service.CalenderService;
import com.green.GreenClassRoom.room.vo.CalenderVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CalenderController {

    private final CalenderService calenderService;

    @PostMapping("/addEvent")
    public ResponseEntity<String> addEvent(@RequestBody CalenderVO calenderVO) {
        calenderService.insertCalender(calenderVO);
        return ResponseEntity.ok("Event added successfully");
    }
}
