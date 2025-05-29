package com.biblioteca.emprestimo.client;

import com.biblioteca.emprestimo.dto.EmailRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "resend", url = "https://api.resend.com")
public interface EmailClient {

    @PostMapping("/emails")
    void enviarEmail(
        @RequestHeader("Authorization") String apiKey,
        @RequestBody EmailRequest emailRequest
    );
}
