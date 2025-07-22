package com.ecommerce.auth.service.impl;

import com.ecommerce.auth.repository.UsersRepository;
import com.ecommerce.auth.response.SaveUserResult;
import com.ecommerce.auth.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class OAuth2ServiceImpl implements LoginService {

    private final UsersRepository usersRepository;

    @Override
    @Async("authTaskExecutor")
    public CompletableFuture<SaveUserResult> checkOAuth2UserExistence(String email, String name, String googleId) {
        try {
            log.info("Checking user existence for: {}", email);

            boolean isUserExist = usersRepository.isUserExist(email, name, googleId);
            if (isUserExist) {
                log.info("User already exists!");
                return CompletableFuture.completedFuture(new SaveUserResult(true, "User already exists!"));
            } else {
                log.info("User not found in DB.");
                return CompletableFuture.completedFuture(new SaveUserResult(false, "User does not exist!"));
            }

        } catch (RuntimeException e) {
            log.error("Error checking user existence", e);
            return CompletableFuture.completedFuture(new SaveUserResult(false, "Error occurred: " + e.getMessage()));
        }
    }

    @Override
    @Async("authTaskExecutor")
    public CompletableFuture<SaveUserResult> recordOAuth2UserToDatabase(String email, String name, String googleId) {
        try {
            log.info("Recording user to DB: {}", email);
            usersRepository.recordUser(email, name, googleId);

            boolean userNowExists = usersRepository.isUserExist(email, name, googleId);
            if (userNowExists) {
                log.info("User successfully recorded!");
                return CompletableFuture.completedFuture(new SaveUserResult(true, "User successfully recorded!"));
            } else {
                log.warn("User insertion failed.");
                return CompletableFuture.completedFuture(new SaveUserResult(false, "User insert failed."));
            }

        } catch (RuntimeException e) {
            log.error("Error recording user", e);
            return CompletableFuture.completedFuture(new SaveUserResult(false, "Error occurred: " + e.getMessage()));
        }
    }
}
