
package com.biblioteca.emprestimo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.emprestimo.model.Emprestimo;
import com.biblioteca.emprestimo.model.StatusEmprestimo;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

	List<Emprestimo> findByAlunoIdAndStatus(Long alunoId, StatusEmprestimo status);
	
	boolean existsByAlunoIdAndStatusIn(Long alunoId, List<String> status);

	
	boolean existsByLivroIdAndStatusIn(Long livroId, List<StatusEmprestimo> statusList);


 
}
