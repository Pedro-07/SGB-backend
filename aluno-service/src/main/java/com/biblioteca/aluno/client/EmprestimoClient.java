package com.biblioteca.aluno.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "emprestimoClient", url = "http://localhost:8083")
public interface EmprestimoClient {

    @GetMapping("/api/emprestimo/aluno/{alunoId}/ativos-ou-atrasados")
    Boolean alunoTemEmprestimosAtivosOuAtrasados(@PathVariable("alunoId") Long alunoId);
}
