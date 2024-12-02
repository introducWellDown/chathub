package com.example.TalkHub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Отключить CSRF (если не используете его в приложении)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Разрешить доступ ко всем запросам
                )
                .httpBasic().disable(); // Отключить Basic Auth

        return http.build();
    }
}
