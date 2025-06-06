package com.biblioteca.aluno.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.aluno.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	boolean existsByMatricula(Integer matricula);
	
	Optional<Aluno> findByMatricula(Integer matricula);
	
	List<Aluno> findByNomeContainingIgnoreCase(String nome);
	
	


}
