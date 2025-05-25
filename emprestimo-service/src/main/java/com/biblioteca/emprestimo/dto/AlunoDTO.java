package com.biblioteca.emprestimo.dto;


import lombok.Data;

@Data
public class AlunoDTO {
	
	private Long id;
	private String nome;
	private Integer matricula;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getMatricula() {
		return matricula;
	}
	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
	
	
	
	
	
}