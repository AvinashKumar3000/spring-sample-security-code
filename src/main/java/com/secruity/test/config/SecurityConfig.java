package com.secruity.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth ->
            auth.requestMatchers(
                    "/login",
                    "/register",
                    "/styles/**",
                    "/scripts/**",
                    "/images/**",
                    "/"
            ).permitAll()
                    .requestMatchers("/admin/**")
                    .hasRole("ADMIN")
                    .requestMatchers("/user/**")
                    .hasRole("USER")

                    .anyRequest()
                    .authenticated()
        ).formLogin(form ->
                form.loginPage("/login")
                        .usernameParameter("email")
                        .defaultSuccessUrl("/redirect-page",true)
                        .permitAll()
        ).logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
        );
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
