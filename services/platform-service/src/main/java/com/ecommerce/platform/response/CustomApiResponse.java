package com.ecommerce.platform.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomApiResponse<T> {
    private boolean success;
    private String message;
    private T data;
}
