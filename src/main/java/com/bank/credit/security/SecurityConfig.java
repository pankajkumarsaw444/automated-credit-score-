package com.bank.credit.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // disable CSRF
            .authorizeHttpRequests(auth -> auth
           	.requestMatchers("/**").permitAll()
      		.anyRequest().authenticated() // secure all others
            )
            .cors(cors -> {}) // enable CORS for Angular frontend

            .headers(headers -> headers.frameOptions(frame -> frame.disable())); // allow H2 console if needed

        return http.build();
    }
}