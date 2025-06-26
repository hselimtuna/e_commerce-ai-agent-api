package com.api.ECommerceAIAgent.controller;

import com.api.ECommerceAIAgent.dto.PlatformSelectionRequest;
import com.api.ECommerceAIAgent.response.ApiResponse;
import com.api.ECommerceAIAgent.service.PlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/platform")
@Tag(name = "Platform Selection Controller", description = "Handles the process for platform selection phase.")
public class PlatformSelectionController {

    private final PlatformService platformService;

    @Autowired
    public PlatformSelectionController(PlatformService platformService) {
        this.platformService = platformService;
    }

    @PostMapping("/select")
    public ResponseEntity<ApiResponse<String>>selectPlatform(@Valid @RequestBody PlatformSelectionRequest request) {
        String result = platformService.handlePlatformSelection(request.getPlatform());
        ApiResponse<String> response = new ApiResponse<>(true, "Platform get successfully !", result);
        return ResponseEntity.ok(response);
    }
}
