package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.jwt.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	JwtAuthenticationFilter authenticationFilter;

	@Bean
	PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf((csrf) -> csrf.disable());
		http.authorizeHttpRequests((authHttpReq) -> authHttpReq.requestMatchers("/file/**").hasRole("ADMIN")
				.requestMatchers("/board/**").hasAnyRole("USER", "ADMIN")
				.requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
				.requestMatchers("/member/insert", "/member/login").permitAll().requestMatchers("/**").permitAll());

		// Session 기반의 인증을 사용하지 않고 JWT를 이용하여서 인증
		http.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		// Spring Security JWT 필터 로드
		http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

}
