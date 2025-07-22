package com.ecommerce.auth;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(properties = {
		"spring.jpa.hibernate.ddl-auto=none",
		"spring.datasource.initialization-mode=never"
})
class AuthApplicationTests {

	@Test
	void contextLoads() {
	}
}
