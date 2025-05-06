package com.petstore.Petstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .headers(headers -> headers.frameOptions().disable()) // For H2
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**", "/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html", "/pet/**").permitAll()
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}
