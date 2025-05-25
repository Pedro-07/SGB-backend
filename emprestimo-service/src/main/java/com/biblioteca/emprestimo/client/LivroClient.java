package com.biblioteca.emprestimo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.biblioteca.emprestimo.dto.LivroDTO;

@FeignClient(name = "livroClient", url = "http://localhost:8082")
public interface LivroClient {
    @GetMapping("api/livro/{id}")
    LivroDTO buscarLivro(@PathVariable("id") Long id);
}
