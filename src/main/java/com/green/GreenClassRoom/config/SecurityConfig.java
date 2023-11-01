package com.green.GreenClassRoom.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception{
        security.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize ->
                  authorize.requestMatchers(
                                new AntPathRequestMatcher("/")
                              , new AntPathRequestMatcher("/room/main")
                            , new AntPathRequestMatcher("/member/loginPage")
                            , new AntPathRequestMatcher("/member/joinPage")
                            , new AntPathRequestMatcher("/member/login")
                            , new AntPathRequestMatcher("/member/checkIdFetch")
                            , new AntPathRequestMatcher("/member/join")
                            , new AntPathRequestMatcher("/member/loginFailResult")
                            , new AntPathRequestMatcher("/book/deleteFreeBookMark")
                            , new AntPathRequestMatcher("/book/insertFreeBookMark")
                            , new AntPathRequestMatcher("/book/deleteNoticeBookMark")
                            , new AntPathRequestMatcher("/book/insertNoticeBookMark")
                            , new AntPathRequestMatcher("/book/deleteBookMark")
                            , new AntPathRequestMatcher("/book/insertBookMark")
                          ).permitAll()
                          .anyRequest().authenticated()
                )
                .formLogin(login ->
                    login.loginPage("/member/loginPage")
                            .loginProcessingUrl("/login")
                            .usernameParameter("memberId")
                            .passwordParameter("memberPw")
                            .defaultSuccessUrl("/member/loginResult", true)
                            .failureUrl("/member/loginFailResult")
                )
                .logout(logout ->
                    logout.logoutUrl("/logout")
                            //로그아웃 시 세션 정보 초기화
                            .invalidateHttpSession(true)
                            .logoutSuccessUrl("/room/main")
                );
        return security.build();
    }

    @Bean
    public WebSecurityCustomizer configure(){
        return (web) -> web.ignoring()
                .requestMatchers(
                        new AntPathRequestMatcher("/js/**")
                        , new AntPathRequestMatcher("/css/**")
                        , new AntPathRequestMatcher("/images/**")
                        , new AntPathRequestMatcher("/upload/**")
                        , new AntPathRequestMatcher("/h2-console/*")
                        , new AntPathRequestMatcher("/webjars/**")
                );
    }
}
