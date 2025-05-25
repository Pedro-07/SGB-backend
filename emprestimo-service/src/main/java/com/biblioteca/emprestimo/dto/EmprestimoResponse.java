package com.biblioteca.emprestimo.dto;

import lombok.Data;
import java.time.LocalDate;
import com.biblioteca.emprestimo.model.StatusEmprestimo;

@Data
public class EmprestimoResponse {
    private Long id;
    private Long alunoId;
    private Integer alunoMatricula;
    private String alunoNome;       
    private Long livroId;
    private String livroIsbn;
    private String livroTitulo;    
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private StatusEmprestimo status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAlunoId() {
		return alunoId;
	}
	public void setAlunoId(Long alunoId) {
		this.alunoId = alunoId;
	}
	public Integer getAlunoMatricula() {
		return alunoMatricula;
	}
	public void setAlunoMatricula(Integer alunoMatricula) {
		this.alunoMatricula = alunoMatricula;
	}
	public String getAlunoNome() {
		return alunoNome;
	}
	public void setAlunoNome(String alunoNome) {
		this.alunoNome = alunoNome;
	}
	public Long getLivroId() {
		return livroId;
	}
	public void setLivroId(Long livroId) {
		this.livroId = livroId;
	}
	public String getLivroIsbn() {
		return livroIsbn;
	}
	public void setLivroIsbn(String livroIsbn) {
		this.livroIsbn = livroIsbn;
	}
	public String getLivroTitulo() {
		return livroTitulo;
	}
	public void setLivroTitulo(String livroTitulo) {
		this.livroTitulo = livroTitulo;
	}
	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public StatusEmprestimo getStatus() {
		return status;
	}
	public void setStatus(StatusEmprestimo status) {
		this.status = status;
	}

    
}
