package com.biblioteca.livro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.biblioteca.livro.model.Livro;

import jakarta.transaction.Transactional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{
	
	@Modifying
	@Transactional
//	@Query("UPDATE Livro l SET l.quantidade = l.quantidade + 1 WHERE l.idLivro = :id")
//	int incrementarQuantidade(@Param("id") Long id);
	
	Optional<Livro> findByTitulo(String titulo);
	
	List<Livro> findByTituloIgnoreCase(String titulo);

	List<Livro> findByTituloContainingIgnoreCase(String termo); 
	
	Optional<Livro> findByIsbn(String isbn);
	
	long countByQuantidadeGreaterThan(int quantidade);
	
}

