package com.ecommerce.auth.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
public class CustomOAuth2FailHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        @NotNull AuthenticationException authenticationException)
            throws IOException, ServletException{

        log.error("OAuth2 authentication failed: {}", authenticationException.getMessage());

        getRedirectStrategy().sendRedirect(httpServletRequest, httpServletResponse, "http://localhost:8081/api/v1/auth/oauth2/failure");
    }
}