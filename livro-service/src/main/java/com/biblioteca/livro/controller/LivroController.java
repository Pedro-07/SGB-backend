package com.biblioteca.livro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.livro.model.Livro;
import com.biblioteca.livro.repository.LivroRepository;
import com.biblioteca.livro.services.LivroService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/livro")
@Tag(name = "Livros", description = "Endpoints para gerenciamento de livros")
public class LivroController {
	
    @Autowired
    private LivroRepository livroRepository;
    
    @Autowired
    private LivroService livroService;
	
   
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @Operation(summary = "Cadastrar um novo livro")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Livro criado com sucesso", content = @Content(schema = @Schema(implementation = Livro.class))),
        @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content)
    })
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarLivro(@Valid @RequestBody Livro livro){
        try {
            Livro respostaLivro = livroService.cadastrar(livro);
            return ResponseEntity.status(HttpStatus.CREATED).body(respostaLivro);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());	
        }
    }

    @Operation(summary = "Buscar livros por termo no título")
    @GetMapping("/titulos")
    public ResponseEntity<List<Livro>> buscarLivros(@RequestParam String termo) {
        List<Livro> livros = livroService.buscarLivrosPorTermo(termo);
        if (livros != null && !livros.isEmpty()) {
            return ResponseEntity.ok(livros);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @Operation(summary = "Buscar livros por título exato")
    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Livro>> buscarPorTitulo(@PathVariable String titulo) {
        List<Livro> livros = livroService.buscarPorTitulo(titulo);
        return livros.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(livros);
    }


    @Operation(summary = "Listar todos os livros")
    @GetMapping("/listar")
    public ResponseEntity<List<Livro>> listarLivros() {
        List<Livro> livros = livroService.verLivros();
        return ResponseEntity.ok(livros);
    }
    
    
    @Operation(summary = "Buscar livro por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Livro encontrado"),
        @ApiResponse(responseCode = "404", description = "Livro não encontrado", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarLivroPorId(@PathVariable Long id) {
        Livro livro = livroService.buscarPorId(id);
        return ResponseEntity.ok(livro);
    }

    
    @Operation(summary = "Editar um livro pelo ID")
    @PutMapping("/{id}")
    public ResponseEntity<Livro> editaLivro(@PathVariable Long id, @RequestBody Livro livro) {
        Livro respostaLivro = livroService.editar(id, livro);
        return ResponseEntity.ok(respostaLivro);
    }

    
    @Operation(summary = "Deletar um livro pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarLivro(@PathVariable Long id) {
        try {
            livroService.deletar(id);
            return ResponseEntity.ok("Livro deletado com sucesso.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }



    @Operation(summary = "Verificar se um livro existe por ID")
    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existsById(@PathVariable Long id) {
        boolean exists = livroService.existsById(id);
        return ResponseEntity.ok(exists);
    }
}
