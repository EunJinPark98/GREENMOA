package com.green.GreenClassRoom.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        //인증과 인가에 대한 설정
        http.csrf(csrf -> csrf.disable())  //csrf 공격에 대한 보안 해제
                .authorizeHttpRequests(authorize ->
                        //authorize.anyRequest().permitAll()  //모든 요청 허용
                        authorize.requestMatchers(
                                                     "/member/joinPage"
                                                    , "/member/join"
                                                    , "/member/loginPage"
                                                    , "/member/login"
                                                    , "/member/logout"

                        ).permitAll()
                                .anyRequest().authenticated()
                );

        return http.build();
    }
}
