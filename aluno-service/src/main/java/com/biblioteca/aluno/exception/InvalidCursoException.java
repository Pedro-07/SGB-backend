package com.biblioteca.aluno.exception;

@SuppressWarnings("serial")
public class InvalidCursoException extends RuntimeException {

    public InvalidCursoException(String message) {
        super(message);
    }
}