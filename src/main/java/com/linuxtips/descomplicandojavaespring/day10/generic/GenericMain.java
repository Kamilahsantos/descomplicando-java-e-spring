package com.linuxtips.descomplicandojavaespring.day10.generic;

public class GenericMain {

    public static void main(String[] args){
        GenericExample<Integer> mensagemInteira = new GenericExample<>(1000);
        mensagemInteira.escrever();
        GenericExample<Double> mensagemDecimal = new GenericExample<>(1234.56);
        mensagemDecimal.escrever();
        GenericExample<String> mensagemString = new GenericExample<>("Mensagem em texto");
        mensagemString.escrever();
    }
}
