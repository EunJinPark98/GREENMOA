package com.green.GreenClassRoom.interceptor;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {
    private final MenuInterceptor menuInterceptor;
    private final LoginInfoInterceptor loginInfoInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //메뉴 던지기
        registry.addInterceptor(menuInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/images/**", "/css/**", "/js/**");

        //로그인 정보 던지기
        registry.addInterceptor(loginInfoInterceptor)
                .addPathPatterns("/room/myRoom")
                .addPathPatterns("/board/freeBoardDetail")
                .addPathPatterns("/board/qnaBoardDetail")
                .excludePathPatterns("/images/**", "/css/**", "/js/**");
    }
}
