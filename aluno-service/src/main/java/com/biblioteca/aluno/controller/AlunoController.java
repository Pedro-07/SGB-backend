package com.biblioteca.aluno.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.biblioteca.aluno.client.EmprestimoClient;
import com.biblioteca.aluno.model.Aluno;
import com.biblioteca.aluno.services.AlunoService;
import com.biblioteca.aluno.dto.AlunoDTO;
import com.biblioteca.aluno.repository.AlunoRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/aluno")
@Tag(name = "Aluno", description = "Gerenciamento de alunos")
public class AlunoController {

	private final AlunoRepository alunoRepository;
    private final AlunoService alunoService;
    private final EmprestimoClient emprestimoclient;

    public AlunoController(AlunoRepository alunoRepository,
                           AlunoService alunoService,
                           EmprestimoClient emprestimoclient) {
        this.alunoRepository = alunoRepository;
        this.alunoService = alunoService;
        this.emprestimoclient = emprestimoclient;
    }

    @Operation(summary = "Cadastrar um novo aluno")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Aluno cadastrado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro de validação")
    })
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarAluno(@Valid @RequestBody Aluno aluno, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        Aluno respostaAluno = alunoService.cadastrar(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(respostaAluno);
    }

    @Operation(summary = "Buscar alunos por nome")
    @GetMapping("/buscar-por-nome")
    public ResponseEntity<List<Aluno>> buscarPorNome(@RequestParam String nome) {
        List<Aluno> alunos = alunoService.buscarPorNome(nome);
        return ResponseEntity.ok(alunos);
    }

    @Operation(summary = "Listar todos os alunos")
    @GetMapping("/listar")
    public ResponseEntity<List<Aluno>> listarTodos() {
        List<Aluno> alunos = alunoService.verAlunos();
        return ResponseEntity.ok(alunos);
    }

    @Operation(summary = "Editar um aluno existente")
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> editarAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
        Aluno alunoAtualizado = alunoService.editar(id, aluno);
        return ResponseEntity.ok(alunoAtualizado);
    }

    @Operation(summary = "Deletar um aluno pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarAluno(@PathVariable Long id) {
        alunoService.deletar(id);
        return ResponseEntity.ok("Aluno deletado com sucesso.");
    }

    @Operation(summary = "Buscar um aluno por ID")
    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> buscarPorId(@PathVariable Long id) {
        return alunoRepository.findById(id)
            .map(aluno -> {
                AlunoDTO dto = new AlunoDTO();
                dto.setId(aluno.getId());
                dto.setNome(aluno.getNome());
                dto.setDataNasc(aluno.getDataNasc() != null ? aluno.getDataNasc().toString() : null);
                dto.setTurno(aluno.getTurno());
                dto.setMatricula(aluno.getMatricula());
                dto.setEmail(aluno.getEmail()); 
                if (aluno.getCurso() != null) {
                    dto.setCursoId(aluno.getCurso().getId());
                    dto.setCursoNome(aluno.getCurso().getNome());
                }
                return ResponseEntity.ok(dto);
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Verificar se o aluno existe por ID")
    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existsById(@PathVariable Long id) {
        boolean exists = alunoService.existsById(id);
        return ResponseEntity.ok(exists);
    }
}
