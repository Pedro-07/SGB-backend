package com.biblioteca.emprestimo.dto;

import java.time.LocalDate;

import com.biblioteca.emprestimo.model.StatusEmprestimo;

public class EmprestimoDetalhadoDTO {
    private Long id;
    private AlunoDTO aluno;
    private LivroDTO livro;
    private StatusEmprestimo status;
    //private String status;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public AlunoDTO getAluno() {
		return aluno;
	}
	public void setAluno(AlunoDTO aluno) {
		this.aluno = aluno;
	}
	public LivroDTO getLivro() {
		return livro;
	}
	public void setLivro(LivroDTO livro) {
		this.livro = livro;
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
