package com.ecommerce.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    @NotNull(message = "E-mail address can't be blank.")
    @Email(message = "Please enter a valid e-mail address.")
    String userEmail;

    @NotNull(message = "Password can't be blank.")
    String password;
}
