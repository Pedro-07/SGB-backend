package com.biblioteca.emprestimo.exception;

@SuppressWarnings("serial")
public class LimiteEmprestimoException extends RuntimeException {
    public LimiteEmprestimoException(String message) {
        super(message);
    }
}