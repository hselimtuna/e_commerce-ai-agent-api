package com.ecommerce.auth.service.impl;


import com.ecommerce.auth.response.SaveUserResult;
import com.ecommerce.auth.service.RegisterService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;


@Service
public class RegisterServiceImpl implements RegisterService {

    private final PasswordEncoder passwordEncoder;

    public RegisterServiceImpl(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Async("authTaskExecutor")
    public CompletableFuture<String>hashPassword(String password){
        String hashedPassword = passwordEncoder.encode(password);
        System.out.println("TEST hashedPassword:" + hashedPassword); /// this line can be deleted later.
        return CompletableFuture.completedFuture(hashedPassword);
    }

    @Override
    @Async("authTaskExecutor")
    public CompletableFuture<SaveUserResult>saveUserToDB(String email, String hashedPassword){
        try {
            /// saving user credentials to DB going to be added to here.
            SaveUserResult result = new SaveUserResult(true, "User saved successfully !");
            return CompletableFuture.completedFuture(result);
        } catch (Exception e) {
            SaveUserResult result = new SaveUserResult(false, "Failed to save user to DB:" + e.getMessage());
            return CompletableFuture.completedFuture(result);
        }
    }


}
