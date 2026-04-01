package com.SpringAI.Helpdesk;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class HelpdeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
		log.info("Application Started");
		log.info("Swagger :{}", "http://localhost:8054/swagger-ui/index.html");
		log.info("API Docs :{}", "http://localhost:8054/v3/api-docs");
		log.info("Mintlify :{}", "http://localhost:3000/Pages");

	}

}
