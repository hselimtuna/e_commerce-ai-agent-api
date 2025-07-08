package com.ecommerce.platform.service.impl;

import com.ecommerce.platform.enums.Platform;
import com.ecommerce.platform.exception.platform.PlatformNotFoundException;
import com.ecommerce.platform.service.PlatformSelectionService;
import org.springframework.stereotype.Service;

@Service
public class PlatformSelectionServiceImpl implements PlatformSelectionService {

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
