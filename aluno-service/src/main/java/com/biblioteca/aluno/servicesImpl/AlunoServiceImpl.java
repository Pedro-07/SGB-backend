package com.biblioteca.aluno.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.biblioteca.aluno.exception.AlunoNotFoundException;
import com.biblioteca.aluno.model.Aluno;
import com.biblioteca.aluno.repository.AlunoRepository;
import com.biblioteca.aluno.services.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService {

	private final AlunoRepository alunoRepository;
    

    public AlunoServiceImpl(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
        
    }

    

    @Override
    public void deletar(Long id) {
        // Verifica se o aluno existe
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        alunoRepository.delete(aluno);
    }

    @Override
    public Aluno cadastrar(Aluno aluno) {
        //
        return alunoRepository.save(aluno);
    }

    @Override
    public List<Aluno> verAlunos() {
        return alunoRepository.findAll();
    }

    @Override
    public Optional<Aluno> buscarPorMatricula(Integer matricula) {
        return alunoRepository.findByMatricula(matricula);
    }

    @Override
    public List<Aluno> buscarPorNome(String nome) {
        return alunoRepository.findByNomeContainingIgnoreCase(nome);
    }

    @Override
    public Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id).orElse(null);
    }

    @Override
    public Aluno editar(Long id, Aluno alunoAtualizado) {
        Aluno alunoExistente = alunoRepository.findById(id)
            .orElseThrow(() -> new AlunoNotFoundException("Aluno não encontrado com id: " + id));

        alunoExistente.setNome(alunoAtualizado.getNome());
        alunoExistente.setDataNasc(alunoAtualizado.getDataNasc());
        alunoExistente.setCurso(alunoAtualizado.getCurso());
        alunoExistente.setTurno(alunoAtualizado.getTurno());
        alunoExistente.setMatricula(alunoAtualizado.getMatricula());

        return alunoRepository.save(alunoExistente);
    }

    @Override
    public boolean existsById(Long id) {
        return alunoRepository.existsById(id);
    }
}
