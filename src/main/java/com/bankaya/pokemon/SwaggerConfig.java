package com.bankaya.pokemon;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        return new OpenAPI()
                .info(new Info()
                        .title("Servicio SOAP Bankaya")
                        .version("1.0")
                        .description("Documentacion para la entrga del Servicio de Pokemon para Bankaya")).servers(List.of(server));
    }
}
