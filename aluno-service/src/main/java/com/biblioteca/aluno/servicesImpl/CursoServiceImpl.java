package com.biblioteca.aluno.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biblioteca.aluno.model.Curso;
import com.biblioteca.aluno.repository.CursoRepository;
import com.biblioteca.aluno.services.CursoService;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }
}
