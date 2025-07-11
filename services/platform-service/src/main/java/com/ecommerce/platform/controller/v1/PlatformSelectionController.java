package com.ecommerce.platform.controller.v1;

import com.ecommerce.platform.dto.v1.PlatformSelectionRequest;
import com.ecommerce.platform.response.CustomApiResponse;
import com.ecommerce.platform.service.PlatformSelectionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("v1/platform")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "Platform Selection Controller v1", description = "Handles the process for platform selection phase.")
public class PlatformSelectionController {

    private final PlatformSelectionService platformSelectionService;

    @PostMapping("/select")
    @Operation(summary = "Platform selection",
            description = "handles platform selection with async processing.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Platform selected succesfully !"),
            @ApiResponse(responseCode = "400", description = "Invalid platform selection"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public CompletableFuture<ResponseEntity<CustomApiResponse<String>>>selectPlatform(@Valid @RequestBody @NotNull PlatformSelectionRequest request) {

        log.info("Platform selection request received: {}", request.getPlatform());

        return platformSelectionService.handlePlatformSelection(request.getPlatform()).thenApply(
                result -> {
                    CustomApiResponse<String> response = new CustomApiResponse<>(true, "Platform get successfully !", result);
                    return ResponseEntity.ok(response);
                });

    }
}
