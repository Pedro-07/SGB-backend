package com.biblioteca.aluno.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.aluno.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
	Optional<Curso> findById(Long id);
}

