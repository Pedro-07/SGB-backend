package com.biblioteca.emprestimo.dto;

import lombok.Data;

@Data
public class LivroDTO {
	
    private Long id;
    private String titulo;
    private String isbn;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
    
	
    
}
