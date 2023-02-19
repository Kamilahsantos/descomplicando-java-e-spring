package com.linuxtips.descomplicandojavaespring.day10.generic;

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
