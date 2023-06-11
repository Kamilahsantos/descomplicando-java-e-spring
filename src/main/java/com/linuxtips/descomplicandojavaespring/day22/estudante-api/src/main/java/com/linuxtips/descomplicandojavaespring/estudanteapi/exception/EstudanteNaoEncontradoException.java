package com.linuxtips.descomplicandojavaespring.estudanteapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Estudante não encontrado na base")
public class EstudanteNaoEncontradoException extends Exception {

    public EstudanteNaoEncontradoException(Long id){
        super("Estudante com o id  "+ id +" não localizado na base");
    }
}
