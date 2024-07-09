package com.jw.menumateapp.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        configureCsrf(http);
        configureAuthorizeRequests(http);
        configureFormLogin(http);
        configureLogout(http);
        return http.build();
    }

    private void configureCsrf(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());
    }

    private void configureAuthorizeRequests(HttpSecurity http) throws Exception {
        http.authorizeRequests(requests -> requests
                .antMatchers("/", "/api/signup", "/api/signupProc", "/login", "/api/login", "/css/**", "/js/**", "/img/**", "/fonts/**",
                        "/assets/**", "/public/**").permitAll()
                .anyRequest().authenticated());
    }

    private void configureFormLogin(HttpSecurity http) throws Exception {
        http.formLogin(login -> login
                .loginPage("/login")
                .loginProcessingUrl("/api/login")
                .usernameParameter("userId")  // 사용자 정의 사용자 이름 필드
                .passwordParameter("userPassword")  // 사용자 정의 비밀번호 필드
                .defaultSuccessUrl("/", true)
                .failureUrl("/login?error=true")
                .permitAll());
    }

    private void configureLogout(HttpSecurity http) throws Exception {
        http.logout(logout -> logout.permitAll());
    }
    
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
    	return new BCryptPasswordEncoder();
    }
}