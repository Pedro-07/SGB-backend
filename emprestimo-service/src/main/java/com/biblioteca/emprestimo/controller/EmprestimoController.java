package com.biblioteca.emprestimo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.emprestimo.client.AlunoClient;
import com.biblioteca.emprestimo.client.LivroClient;
import com.biblioteca.emprestimo.dto.AlunoDTO;
import com.biblioteca.emprestimo.dto.EmprestimoDetalhadoDTO;
import com.biblioteca.emprestimo.dto.EmprestimoRequest;
import com.biblioteca.emprestimo.dto.EmprestimoResponse;
import com.biblioteca.emprestimo.dto.LivroDTO;
import com.biblioteca.emprestimo.model.Emprestimo;
import com.biblioteca.emprestimo.repository.EmprestimoRepository;
import com.biblioteca.emprestimo.services.EmprestimoService;

@RestController
@RequestMapping("/api/emprestimo")
public class EmprestimoController {

	private final EmprestimoService emprestimoService;
	private final EmprestimoRepository repository;
	private final AlunoClient alunoClient;
	private final LivroClient livroClient;

	public EmprestimoController(
	    EmprestimoService emprestimoService,
	    EmprestimoRepository repository,
	    AlunoClient alunoClient,
	    LivroClient livroClient
	) {
	    this.emprestimoService = emprestimoService;
	    this.repository = repository;
	    this.alunoClient = alunoClient;
	    this.livroClient = livroClient;
	}

    @PostMapping("/emprestar")
    public ResponseEntity<?> emprestarLivro(@RequestBody EmprestimoRequest request) {
        try {
            EmprestimoResponse resposta = emprestimoService.realizarEmprestimo(request);
            return ResponseEntity.ok(resposta);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
        	e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar o empréstimo.");
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<EmprestimoResponse>> listarEmprestimos() {
        return ResponseEntity.ok(emprestimoService.listarPendentes());
    }




    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarEmprestimo(@PathVariable Long id) {
        if (!emprestimoService.existeEmprestimo(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empréstimo não encontrado.");
        }
        emprestimoService.deletarPorId(id);
        return ResponseEntity.ok("Empréstimo deletado com sucesso.");
    }
	
	
}
















