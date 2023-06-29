package com.linuxtips.descomplicandojavaespring.estudanteapi.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Estudante duplicado - já existe um estudante com esse nome")
public class EstudanteDuplicadoException extends Exception {
    public EstudanteDuplicadoException() {
        super();
    }

    public EstudanteDuplicadoException(String message) {
        super();
    }
}
