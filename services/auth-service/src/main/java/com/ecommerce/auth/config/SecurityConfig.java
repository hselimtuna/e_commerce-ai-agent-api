package com.ecommerce.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean(name = "securityDev")
    @Profile(value = "dev")
    public SecurityFilterChain devSecurity(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/auth/**",
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/api-docs/**",
                                "/swagger-ui.html",
                                "/webjars/**"
                        )
                        .permitAll().anyRequest().authenticated())

                .formLogin(form -> form.disable())
                .httpBasic(basic -> basic.disable())

                .headers(headers -> headers
                        .xssProtection(xss -> xss.disable())
                        .frameOptions(frame -> frame.disable()));

        return httpSecurity.build();
    }


}
