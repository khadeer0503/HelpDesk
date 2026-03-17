package com.SpringAI.Helpdesk.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerOpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                        .title("Helpdesk AI API")
                        .version("1.0")
                        .contact(new Contact().email("mohammed.khadeeruddin@ctlup.com"))
                        .description("API documentation for the Helpdesk AI system")
                )
                .servers(
                    List.of(
                            new Server().url("http://localhost:8054").description("Dev server"),
                            new Server().url("http://localhost:8053").description("Production server")
                    )
                )
                .tags(List.of(new Tag().name("Helpdesk AI Controller").description("Endpoints for AI interactions in the Helpdesk system")));

    }
}
