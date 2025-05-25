package com.biblioteca.emprestimo.services;

import java.util.List;

import com.biblioteca.emprestimo.dto.EmprestimoRequest;
import com.biblioteca.emprestimo.dto.EmprestimoResponse;

public interface EmprestimoService {
	
	EmprestimoResponse realizarEmprestimo(EmprestimoRequest request);
	
	List<EmprestimoResponse> listarPendentes();

    void deletarPorId(Long id);

    boolean existeEmprestimo(Long id);
	
	
	//void deletar(Long id);

//    Emprestimo emprestar(Emprestimo emprestimo);
//
//    List<Emprestimo> listarPendentes();
//
//    void deletar(Long idEmprestimo);
//
//    Emprestimo buscarPorId(Long idEmprestimo);
//
//    // Método para validar se existe empréstimo ativo para determinado aluno
//    boolean existeEmprestimoAtivoPorAluno(Long id_aluno);
//
//    // Método para validar se existe empréstimo ativo para determinado livro
//    boolean existeEmprestimoAtivoPorLivro(Long idLivro);
//
//    Emprestimo registrarDevolucao(Long idEmprestimo);
//
}
