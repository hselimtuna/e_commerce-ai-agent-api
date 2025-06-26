package com.api.ECommerceAIAgent.service.impl;

import com.api.ECommerceAIAgent.enums.Platform;
import com.api.ECommerceAIAgent.exception.platform.PlatformNotFoundException;
import com.api.ECommerceAIAgent.service.PlatformService;
import org.springframework.stereotype.Service;

@Service
public class PlatformServiceImpl implements PlatformService {

    @Override
    public String handlePlatformSelection(Platform platform){
        if (platform == null){
            throw new PlatformNotFoundException("Platform can't be blank.");
        }

        return switch (platform) {
            case TRENDYOL -> "Trendyol logic...";
            case HEPSIBURADA -> "Hepsiburada logic...";
            case AMAZON -> "Amazon logic...";
            default -> throw new PlatformNotFoundException("Invalid platform: " + platform);
        };
    }

}
