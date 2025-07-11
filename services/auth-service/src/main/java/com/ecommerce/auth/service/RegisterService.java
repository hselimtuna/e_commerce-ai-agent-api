package com.ecommerce.auth.service;

import com.ecommerce.auth.response.SaveUserResult;
import java.util.concurrent.CompletableFuture;

public interface RegisterService {

    CompletableFuture<String>hashPassword(String password);
    CompletableFuture<SaveUserResult>saveUserToDB(String email, String hashedPassword);
}
