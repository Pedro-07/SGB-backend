package com.biblioteca.aluno.services;

import com.biblioteca.aluno.model.Aluno;

import java.util.List;
import java.util.Optional;

public interface AlunoService {

    Aluno cadastrar(Aluno aluno);

    List<Aluno> verAlunos();

    Optional<Aluno> buscarPorMatricula(Integer matricula);

    List<Aluno> buscarPorNome(String nome);

    Aluno buscarPorId(Long id);

    Aluno editar(Long id, Aluno alunoAtualizado);

    void deletar(Long id);
    
    boolean existsById(Long id);

}
