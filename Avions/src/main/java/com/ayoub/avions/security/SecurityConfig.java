package com.ayoub.avions.security;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(cors -> cors.configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                        CorsConfiguration config = new CorsConfiguration();
                        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                        config.setAllowedMethods(Collections.singletonList("*"));
                        config.setAllowCredentials(true);
                        config.setAllowedHeaders(Collections.singletonList("*"));
                        config.setExposedHeaders(Arrays.asList("Authorization"));
                        config.setMaxAge(3600L);
                        return config;
                    }
                }))
                .authorizeRequests(req -> req
                        .requestMatchers(new AntPathRequestMatcher("/api/all/**")).hasAnyAuthority("USER", "ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/api/getbyid/**")).hasAnyAuthority("USER", "ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/api/addav/**")).hasAuthority("ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/api/updateav/**")).hasAuthority("ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/api/delav/**")).hasAuthority("ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/api/avcom/**")).hasAnyAuthority("USER", "ADMIN")
                        .anyRequest().authenticated())
                .addFilterBefore(new JWTAuthorizationFilter(), BasicAuthenticationFilter.class);
        return http.build();
    }
}
