package com.biblioteca.emprestimo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI livroServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Empréstimos - Biblioteca")
                        .description("Documentação da API responsável pelo gerenciamento de empréstimos no sistema da biblioteca.")
                        .version("1.0.0"));
    }
}
