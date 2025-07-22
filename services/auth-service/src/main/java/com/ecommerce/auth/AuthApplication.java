package com.ecommerce.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Slf4j
public class AuthApplication {

	public static void main(String[] args) {


		ConfigurableApplicationContext context = SpringApplication.run(
				AuthApplication.class, args
		);

		Environment env = context.getEnvironment();
		String[] activeProfiles = env.getActiveProfiles();
		String port = env.getProperty("server.port");
		String contextPath = env.getProperty("server.servlet.context-path", "");

		log.info("===========================================");
		log.info("Application '{}' is running!", env.getProperty("spring.application.name"));
		log.info("Active profiles: {}", String.join(", ", activeProfiles));
		log.info("Local: http://localhost:{}{}", port, contextPath);
		log.info("Swagger UI: http://localhost:{}{}/swagger-ui.html", port, contextPath);
		log.info("===========================================");
	}
}

