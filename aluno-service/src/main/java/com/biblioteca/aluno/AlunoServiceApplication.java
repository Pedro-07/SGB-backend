package com.biblioteca.aluno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AlunoServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AlunoServiceApplication.class, args);
    }
}
