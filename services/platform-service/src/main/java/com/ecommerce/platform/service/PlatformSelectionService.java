package com.ecommerce.platform.service;

import com.ecommerce.platform.enums.Platform;

import java.util.concurrent.CompletableFuture;

public interface PlatformSelectionService {

    CompletableFuture<String> handlePlatformSelection (Platform platform);
}
