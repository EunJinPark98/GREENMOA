package com.green.GreenClassRoom.interceptor;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {
    private final MenuInterceptor menuInterceptor;
    private final CheckLoginInterceptor checkLoginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(menuInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/images/**", "/css/**", "/js/**");
        registry.addInterceptor(checkLoginInterceptor)
                .addPathPatterns("/board/**")
                .excludePathPatterns("/images/**", "/css/**", "/js/**");
    }
}
