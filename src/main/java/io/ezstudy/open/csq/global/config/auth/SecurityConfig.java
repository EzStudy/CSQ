package io.ezstudy.open.csq.global.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
            .csrf().disable()
            .headers().frameOptions().disable()
            .and()
            .authorizeRequests()
            .antMatchers("/","/h2-console/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .logout()
            .logoutSuccessUrl("/")
            .and()
            .oauth2Login().userInfoEndpoint().userService(customOAuth2UserService);
    }
}
/*
* @EnableWebSecurity
*  Spring Security 설정들을 활서오하 시켜줍니다.
* logout().logoutSuccessUrl("/")
*  로그아웃 기능에 대한 여러 설정의 진입점입니다.
*  로그아웃 성공 시 / 주소로 이동합니다.
* oauth2Login()
*  OAuth 2 로그인 기능에 대한 여러 설정의 진입점입니다.
* userInfoEndpoint()
*  OAuth 2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들을 담당합니다.
* userService
*  소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록합니다.
*  리로스 서버(구글, 페북, 카카오)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능을 명시할 수 잇ㅆ브니다.*/