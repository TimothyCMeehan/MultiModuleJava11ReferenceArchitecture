package com.globe.dom.service;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Globedom.com API Docs", version = "v1.0.0", description = "GLOBE DOM REST API documentation"))
public class ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }

}
