package com.linuxtips.descomplicandojavaespring.estudanteapi.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EstudanteNaoEncontradoException.class)
    public ResponseEntity<String> handleEstudanteNaoEncontradoException(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage() + "\n" + ex.getClass());
    }
}
