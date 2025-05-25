package com.biblioteca.emprestimo.dto;

import java.time.LocalDate;

import com.biblioteca.emprestimo.model.StatusEmprestimo;

import lombok.Data;

@Data
public class EmprestimoRequest {
    private Long alunoId;
    private Long livroId;
    private StatusEmprestimo status;
    //private String status;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
	public Long getAlunoId() {
		return alunoId;
	}
	public void setAlunoId(Long alunoId) {
		this.alunoId = alunoId;
	}
	public Long getLivroId() {
		return livroId;
	}
	public void setLivroId(Long livroId) {
		this.livroId = livroId;
	}
	public StatusEmprestimo getStatus() {
		return status;
	}
	public void setStatus(StatusEmprestimo status) {
		this.status = status;
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
    
	
}

