package com.api.ECommerceAIAgent.dto;

import com.api.ECommerceAIAgent.enums.Platform;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatformSelectionRequest {

    @NotNull(message = "Platform selection is mandatory.")
    private Platform platform;

}
