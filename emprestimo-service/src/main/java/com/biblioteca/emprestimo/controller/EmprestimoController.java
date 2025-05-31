package com.biblioteca.emprestimo.controller;

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
import com.biblioteca.emprestimo.dto.EmprestimoRequest;
import com.biblioteca.emprestimo.dto.EmprestimoResponse;
import com.biblioteca.emprestimo.repository.EmprestimoRepository;
import com.biblioteca.emprestimo.services.EmprestimoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/emprestimo")
@Tag(name = "Empréstimos", description = "Gerenciamento de empréstimos")
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

	@Operation(
	        summary = "Emprestar livro", 
	        description = "Realiza o empréstimo de um livro para um aluno. Retorna a resposta do empréstimo."
	    )
	    @ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Empréstimo realizado com sucesso"),
	        @ApiResponse(responseCode = "400", description = "Erro na requisição, como empréstimo não permitido"),
	        @ApiResponse(responseCode = "500", description = "Erro interno ao processar o empréstimo")
	    })
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

	
	@Operation(
	        summary = "Listar empréstimos pendentes", 
	        description = "Retorna a lista de todos os empréstimos pendentes."
	    )
	    @ApiResponse(responseCode = "200", description = "Lista de empréstimos pendentes")
    @GetMapping("/listar")
    public ResponseEntity<List<EmprestimoResponse>> listarEmprestimos() {
        return ResponseEntity.ok(emprestimoService.listarPendentes());
    }



	 @Operation(
		        summary = "Deletar empréstimo", 
		        description = "Deleta um empréstimo com o ID fornecido."
		    )
		    @ApiResponses(value = {
		        @ApiResponse(responseCode = "200", description = "Empréstimo deletado com sucesso"),
		        @ApiResponse(responseCode = "404", description = "Empréstimo não encontrado")
		    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarEmprestimo(@PathVariable Long id) {
        if (!emprestimoService.existeEmprestimo(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empréstimo não encontrado.");
        }
        emprestimoService.deletarPorId(id);
        return ResponseEntity.ok("Empréstimo deletado com sucesso.");
    }
	
	
}
















