package com.green.GreenClassRoom.room.controller;

import com.green.GreenClassRoom.room.service.CalenderService;
import com.green.GreenClassRoom.room.vo.CalenderVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CalenderController {
    private final CalenderService calenderService;

    //캘린더 조회
    @GetMapping("/getEvents")
    public ResponseEntity<List<Map<String, Object>>> getEvents() {
        List<CalenderVO> events = calenderService.selectCalender();
        List<Map<String, Object>> calendarEvents = new ArrayList<>();

        for (CalenderVO event : events) {
            Map<String, Object> calendarEvent = new HashMap<>();
            calendarEvent.put("title", event.getCalTitle());
            calendarEvent.put("start", event.getCalDate());
            calendarEvents.add(calendarEvent);
        }
        return ResponseEntity.ok(calendarEvents);
    }

    //캘린더 일정 추가
    @PostMapping("/addEvent")
    public ResponseEntity<String> addEvent(@RequestBody CalenderVO calenderVO) {
        try {
            calenderService.insertCalender(calenderVO);
            return ResponseEntity.ok("일정이 추가되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("오류");
        }
    }


}
