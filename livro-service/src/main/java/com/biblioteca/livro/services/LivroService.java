package com.biblioteca.livro.services;

import java.util.List;

import com.biblioteca.livro.model.Livro;

public interface LivroService {
	
	Livro cadastrar(Livro livro);
	List<Livro> verLivros();
	void deletar(Long idLivro);
	List<Livro> buscarLivrosPorTermo(String termo);
	//Livro buscarPorTitulo(String titulo);
	Livro editar(Long id, Livro livroAtualizado);
	Livro buscarPorId(Long id);
	boolean existsById(Long id);
	List<Livro> buscarPorTitulo(String titulo);
	//boolean existeEmprestimoAtivo(Long idLivro);
}
