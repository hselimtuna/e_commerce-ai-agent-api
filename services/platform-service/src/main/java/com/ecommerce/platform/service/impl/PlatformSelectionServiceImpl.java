package com.ecommerce.platform.service.impl;

import com.ecommerce.platform.enums.Platform;
import com.ecommerce.platform.exception.platform.PlatformNotFoundException;
import com.ecommerce.platform.service.PlatformSelectionService;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

@Service
@Slf4j
public class PlatformSelectionServiceImpl implements PlatformSelectionService {

    @Override
    @Async("platformTaskExecutor")
    public CompletableFuture<String> handlePlatformSelection(Platform platform) {

        if (platform == null) {
            throw new PlatformNotFoundException("Platform can't be blank.");
        }

        try {
            Thread.sleep(1000);
            String result = switch (platform) {
                case TRENDYOL -> processTrendyol();
                case HEPSIBURADA -> processHepsiburada();
                case AMAZON -> processAmazon();
                default -> throw new PlatformNotFoundException("Invalid platform: " + platform);
            };

            return CompletableFuture.completedFuture(result);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new CompletionException(e);
        }
    }

    private @NotNull String processTrendyol() {
        log.debug("Processing Trendyol integration...");
        return "Trendyol integration processed successfully";
    }

    private @NotNull String processHepsiburada() {
        log.debug("Processing Hepsiburada integration...");
        return "Hepsiburada integration processed successfully";
    }

    private @NotNull String processAmazon() {
        log.debug("Processing Amazon integration...");
        return "Amazon integration processed successfully";
    }
}