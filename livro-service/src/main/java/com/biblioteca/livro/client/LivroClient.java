package com.biblioteca.livro.client;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "livro-service", url = "http://localhost:8082/api/livro")
public interface LivroClient {

    @GetMapping("/exists/{id}")
    Boolean existsById(@PathVariable("id") Long id);
}
