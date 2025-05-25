package com.biblioteca.emprestimo.client;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.biblioteca.emprestimo.dto.AlunoDTO;

@FeignClient(name = "alunoClient", url = "http://localhost:8081")
public interface AlunoClient {
    @GetMapping("/api/aluno/{id}")
    AlunoDTO buscarAluno(@PathVariable("id") Long id);
}

