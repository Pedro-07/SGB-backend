package com.biblioteca.emprestimo.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biblioteca.emprestimo.client.AlunoClient;
import com.biblioteca.emprestimo.client.LivroClient;
import com.biblioteca.emprestimo.dto.AlunoDTO;
import com.biblioteca.emprestimo.dto.EmprestimoRequest;
import com.biblioteca.emprestimo.dto.EmprestimoResponse;
import com.biblioteca.emprestimo.dto.LivroDTO;
import com.biblioteca.emprestimo.model.Emprestimo;
import com.biblioteca.emprestimo.model.StatusEmprestimo;
import com.biblioteca.emprestimo.repository.EmprestimoRepository;
import com.biblioteca.emprestimo.services.EmprestimoService;

@Service
public class EmprestimoServiceImpl implements EmprestimoService {
	private final AlunoClient alunoClient;
    private final LivroClient livroClient;
    private final EmprestimoRepository repository;

    public EmprestimoServiceImpl(AlunoClient alunoClient, LivroClient livroClient, EmprestimoRepository repository) {
        this.alunoClient = alunoClient;
        this.livroClient = livroClient;
        this.repository = repository;
    }

    @Override
    public EmprestimoResponse realizarEmprestimo(EmprestimoRequest request) {
        AlunoDTO aluno = alunoClient.buscarAluno(request.getAlunoId());
        LivroDTO livro = livroClient.buscarLivro(request.getLivroId());
        
        List<Emprestimo> emprestimosAtivos = repository.findByAlunoIdAndStatus(aluno.getId(), StatusEmprestimo.ATIVO);
        if (emprestimosAtivos.size() >= 3) {
            throw new IllegalStateException("Limite de empréstimos atingido para este aluno.");
        }

        Emprestimo emp = new Emprestimo();
        emp.setAlunoId(aluno.getId());
        emp.setLivroId(livro.getId());
        emp.setDataEmprestimo(request.getDataEmprestimo());
        emp.setDataDevolucao(request.getDataDevolucao());
        
        emp.setStatus(request.getStatus());

        repository.save(emp);

        EmprestimoResponse resp = new EmprestimoResponse();
        resp.setId(emp.getId());
        resp.setAlunoId(emp.getAlunoId());
        resp.setAlunoMatricula(aluno.getMatricula()); 
        resp.setLivroId(emp.getLivroId());
        resp.setLivroIsbn(livro.getIsbn());           
        resp.setDataEmprestimo(emp.getDataEmprestimo());
        resp.setDataDevolucao(emp.getDataDevolucao());
        resp.setStatus(emp.getStatus());

        return resp;
    }
    
    @Override
    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existeEmprestimo(Long id) {
        return repository.existsById(id);
    }
    
    @Override
    public List<EmprestimoResponse> listarPendentes() {
        List<Emprestimo> emprestimos = repository.findAll();

        return emprestimos.stream().map(e -> {
            EmprestimoResponse resp = new EmprestimoResponse();
            resp.setId(e.getId());
            resp.setAlunoId(e.getAlunoId());
            resp.setLivroId(e.getLivroId());
            resp.setDataEmprestimo(e.getDataEmprestimo());
            resp.setDataDevolucao(e.getDataDevolucao());
            resp.setStatus(e.getStatus());

            try {
                AlunoDTO aluno = alunoClient.buscarAluno(e.getAlunoId());
                resp.setAlunoMatricula(aluno.getMatricula());
                resp.setAlunoNome(aluno.getNome());
            } catch (Exception ex) {
                resp.setAlunoNome("Aluno não encontrado");
                resp.setAlunoMatricula(null);
            }

            try {
                LivroDTO livro = livroClient.buscarLivro(e.getLivroId());
                resp.setLivroIsbn(livro.getIsbn());
                resp.setLivroTitulo(livro.getTitulo());
            } catch (Exception ex) {
                resp.setLivroTitulo("Livro não encontrado");
                resp.setLivroIsbn(null);
            }

            return resp;
        }).toList();
    }





}