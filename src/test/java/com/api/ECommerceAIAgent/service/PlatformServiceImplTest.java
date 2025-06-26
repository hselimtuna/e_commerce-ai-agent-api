package com.api.ECommerceAIAgent.service;

import com.api.ECommerceAIAgent.enums.Platform;
import com.api.ECommerceAIAgent.exception.platform.PlatformNotFoundException;
import com.api.ECommerceAIAgent.service.impl.PlatformServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class PlatformServiceImplTest {

    private PlatformServiceImpl platformService;

    @BeforeAll
    static void globalSetup() {
        log.info("Global Setup - Test starting...");
    }

    @AfterAll
    static void globalTeardown() {
        log.info("Global teardown - Test finished.");
    }

    @BeforeEach
    void setUp() {
        platformService = new PlatformServiceImpl();
    }

    @AfterEach
    void tearDown() {
        platformService = null;
    }

    @ParameterizedTest(name = "For Platform {0}, Do the output is right ?")
    @EnumSource(Platform.class)
    void testHandlePlatformSelection_AllPlatforms(Platform platform) {
        String result = platformService.handlePlatformSelection(platform);

        String expected = switch (platform) {
            case TRENDYOL -> "Trendyol logic...";
            case HEPSIBURADA -> "Hepsiburada logic...";
            case AMAZON -> "Amazon logic...";
        };
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Invalid Platform: throws PlatformNotFoundException")
    void testHandlePlatformSelection_InvalidPlatform() {
        Platform invalidPlatform = null;
        Assertions.assertThrows(PlatformNotFoundException.class, () -> platformService.handlePlatformSelection(invalidPlatform));
    }

}
