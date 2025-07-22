package com.ecommerce.auth.controller.v1;

import com.ecommerce.auth.response.CustomApiResponse;
import com.ecommerce.auth.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.Executor;

@RestController
@RequestMapping("v1/auth")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Login Controller", description = "Handles registration and login processes by APIs.")
public class LoginController {

    private final LoginService loginService;

    @Qualifier("authTaskExecutor")
    private final Executor asyncExecutor;

    @GetMapping("oauth2/login")
    @Operation(summary = "Login page", description = "Redirects to Google OAuth2 login.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "302", description = "Redirect to Google OAuth2"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public CompletableFuture<Void> initiateOAuth2Login(HttpServletResponse response) {
        return CompletableFuture.runAsync(() -> {
            try {
                log.info("Initiating OAuth2 login redirect (async)");
                response.sendRedirect("/oauth2/authorization/google");
            } catch (IOException e) {
                throw new CompletionException(e);
            }
        }, asyncExecutor);
    }

    @GetMapping("oauth2/failure")
    public ResponseEntity<CustomApiResponse<String>> oAuth2Failure() {
        log.info("OAuth2 login failed.");
        CustomApiResponse<String> response = new CustomApiResponse<>(false, "OAuth2 registration failed!", null);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

}