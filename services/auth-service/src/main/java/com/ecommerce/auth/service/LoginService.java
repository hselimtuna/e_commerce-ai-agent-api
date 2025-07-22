package com.ecommerce.auth.service;

import com.ecommerce.auth.response.SaveUserResult;
import java.util.concurrent.CompletableFuture;

public interface LoginService {

    CompletableFuture<SaveUserResult>checkOAuth2UserExistence(String email, String name, String googleId);
    CompletableFuture<SaveUserResult>recordOAuth2UserToDatabase(String email, String name, String googleId);
}
