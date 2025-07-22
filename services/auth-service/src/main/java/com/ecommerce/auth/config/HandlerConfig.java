package com.ecommerce.auth.config;

import com.ecommerce.auth.handler.CustomOAuth2FailHandler;
import com.ecommerce.auth.handler.CustomOAuth2SuccessHandler;
import com.ecommerce.auth.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class HandlerConfig {

    private final LoginService loginService;

    @Bean(name = "CustomOAuth2SuccessHandler")
    public CustomOAuth2SuccessHandler customOAuth2SuccessHandler() {
        return new CustomOAuth2SuccessHandler(loginService);
    }

    @Bean(name = "CustomOAuth2FailHandler")
    public CustomOAuth2FailHandler customOAuth2FailHandler() {
        return new CustomOAuth2FailHandler();
    }
}