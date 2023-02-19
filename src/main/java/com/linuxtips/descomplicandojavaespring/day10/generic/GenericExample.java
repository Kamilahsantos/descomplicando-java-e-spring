package com.linuxtips.descomplicandojavaespring.day10.generic;

// vieram para facilitar principalmente casos de casting entre tipos
//reduzindo a complexidade e volume de código escrito dados
//  podemos usar um tipo genérico de dados.
public class GenericExample <T>{
    public GenericExample(T mensagem) {
        this.name = mensagem;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    T name;

    public void escrever() {
        System.out.println(name);
    }

}
