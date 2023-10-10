package com.green.GreenClassRoom.interceptor;

import com.green.GreenClassRoom.member.vo.MemberVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class CheckLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        MemberVO loginInfo=(MemberVO)session.getAttribute("loginInfo");
        if(loginInfo==null){
            response.sendRedirect("/");
            return false;
        }
        return true;
    }
}
