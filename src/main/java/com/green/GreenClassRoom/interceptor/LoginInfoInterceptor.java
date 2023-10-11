package com.green.GreenClassRoom.interceptor;

import com.green.GreenClassRoom.member.vo.MemberVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@RequiredArgsConstructor
public class LoginInfoInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
        if (loginInfo == null) {
            response.sendRedirect("/room/main");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HttpSession session = request.getSession();
        MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
        if(modelAndView!=null){
            modelAndView.addObject("loginInfo", loginInfo);
            System.out.println(loginInfo);
        }
    }
}
