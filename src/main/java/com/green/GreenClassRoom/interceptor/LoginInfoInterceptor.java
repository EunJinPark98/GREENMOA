package com.green.GreenClassRoom.interceptor;

import com.green.GreenClassRoom.member.service.MemberService;
import com.green.GreenClassRoom.member.vo.MemberVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LoginInfoInterceptor implements HandlerInterceptor {
    private final MemberService memberService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        System.out.println(":@@@@@@@@@@@@@@@@@@@@@@@@" + authentication);
//        User user =  (User) authentication.getPrincipal();
//        System.out.println("!!!!!" + user.getUsername());
//
//        if(authentication != null){
//
//            modelAndView.addObject("loginInfo", memberService.selectLoginInfo(user.getUsername()));
//        }

    }
}
