package com.ecommerce.auth.handler;

import com.ecommerce.auth.service.LoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
@Slf4j
public class CustomOAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final LoginService loginService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        @NotNull Authentication authentication)
            throws IOException, ServletException {

        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();

        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");
        String googleId = oAuth2User.getAttribute("sub");

        log.info("OAuth2 login successful for user: {}", email);

        loginService.checkOAuth2UserExistence(email, name, googleId).thenCompose(existenceResult ->
        {
            if (existenceResult != null && existenceResult.success()){
                log.info("OAuth2User exist !");
                return CompletableFuture.completedFuture(existenceResult);
        } else {
                log.info("Saving OAuth2 credentials to DB");
                return loginService.recordOAuth2UserToDatabase(email, name, googleId);
        }
        }).thenAccept(finalResult -> {
            if (finalResult != null && finalResult.success()){
                log.info("New OAuth2 user: {} saved !", email);
                try {
                    getRedirectStrategy().sendRedirect(httpServletRequest, httpServletResponse, "http://localhost:8082/api/swagger-ui/index.html");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try{
                    System.out.println("ANANI SİKECEM JAVA");
                    getRedirectStrategy().sendRedirect(httpServletRequest, httpServletResponse, "http://localhost:8081/api/v1/auth/oauth2/failure");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}