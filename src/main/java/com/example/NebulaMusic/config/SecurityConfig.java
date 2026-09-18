package com.example.NebulaMusic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth.requestMatchers(
                        "/",
                        "/index",
                        "/index.html",
                        "/login",
                        "/login.html",
                        "/registro",
                        "/registro.html",
                        "/error",
                        "/error.html",
                        "/crear-cuenta",
                        "/autenticacion",
                        "/styles/**",
                        "/imgs/**"
                ).permitAll().anyRequest().authenticated()
                );
        return http.build();
    }

}
