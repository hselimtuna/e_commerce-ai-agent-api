package com.api.platform.service.impl;

import com.api.platform.enums.Platform;
import com.api.platform.exception.platform.PlatformNotFoundException;
import com.api.platform.service.PlatformSelectionService;
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
