package com.green.GreenClassRoom.session;

import com.green.GreenClassRoom.member.service.MemberService;
import com.green.GreenClassRoom.member.vo.MemberVO;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionListener implements HttpSessionListener {
    @Autowired
    private MemberService memberService;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
        if (loginInfo != null) {
            memberService.connectOff(loginInfo.getMemberId());
        }
    }
}
