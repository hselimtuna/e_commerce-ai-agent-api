package com.api.platform.exception.platform;

public class PlatformNotFoundException extends RuntimeException{

    public PlatformNotFoundException(String message){
        super(message);
    }
}
