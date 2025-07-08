package com.api.platform.service;

import com.api.platform.enums.Platform;
import com.api.platform.exception.platform.PlatformNotFoundException;
import com.api.platform.service.impl.PlatformSelectionServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class PlatformServiceImplTest {

    @InjectMocks
    private PlatformSelectionServiceImpl platformSelectionService;

    private AutoCloseable closeable;

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
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
        platformSelectionService = null;
    }

    @ParameterizedTest(name = "For Platform {0}, Do the output is right ?")
    @EnumSource(Platform.class)
    void testHandlePlatformSelection_AllPlatforms(Platform platform) {
        String result = platformSelectionService.handlePlatformSelection(platform);

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
        Assertions.assertThrows(PlatformNotFoundException.class, () -> platformSelectionService.handlePlatformSelection(invalidPlatform));
    }
}