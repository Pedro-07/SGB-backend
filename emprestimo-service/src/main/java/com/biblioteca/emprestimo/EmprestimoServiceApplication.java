package com.biblioteca.emprestimo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.biblioteca.emprestimo.client")
public class EmprestimoServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmprestimoServiceApplication.class, args);
    }
}
