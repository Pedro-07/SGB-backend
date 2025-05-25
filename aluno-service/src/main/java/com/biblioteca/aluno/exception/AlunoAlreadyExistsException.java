package com.biblioteca.aluno.exception;

@SuppressWarnings("serial")
public class AlunoAlreadyExistsException extends RuntimeException {

    public AlunoAlreadyExistsException(String message) {
        super(message);
    }
}
