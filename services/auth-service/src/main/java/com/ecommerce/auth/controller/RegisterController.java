package com.ecommerce.auth.controller;

import com.ecommerce.auth.dto.RegisterRequest;
import com.ecommerce.auth.response.CustomApiResponse;
import com.ecommerce.auth.service.RegisterService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/auth")

@Tag(name = "Register Controller", description = "Handles registration flows by APIs.")
public class RegisterController {

    private final RegisterService registerService;

    @Autowired
    public RegisterController (RegisterService registerService){
        this.registerService = registerService;
    }

    @PostMapping("/register")
    @Async("authTaskExecutor")
    public CompletableFuture<ResponseEntity<CustomApiResponse<String>>>registerPlatform(@Valid @RequestBody RegisterRequest registerRequest){

        String email = registerRequest.getUserEmail();
        String password = registerRequest.getPassword();

        return registerService.hashPassword(password).thenCompose(
                hashedPassword -> registerService.saveUserToDB(email, hashedPassword)
        ).thenApply(saveResult ->{
            if (saveResult != null && saveResult.success()) {
                HttpStatus status = HttpStatus.OK;
                CustomApiResponse<String> response = new CustomApiResponse<>(true, saveResult.message(), null);
                return ResponseEntity.status(status).body(response);
            } else {
                HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
                CustomApiResponse<String> response = new CustomApiResponse<>(false, saveResult != null ? saveResult.message() : "Unknown error", null);
                return ResponseEntity.status(status).body(response);
            }
        });
    }
}
