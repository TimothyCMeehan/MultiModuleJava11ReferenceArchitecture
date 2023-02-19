package com.globe.dom.service.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI globeDomOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Globedom.com API Docs")
                        .description("GLOBE DOM REST API documentation")
                        .version("v1.0.0"));
    }

}
