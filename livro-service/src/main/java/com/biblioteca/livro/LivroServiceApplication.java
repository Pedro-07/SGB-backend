package com.biblioteca.livro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.biblioteca.livro.client")
public class LivroServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(LivroServiceApplication.class, args);
    }
}
