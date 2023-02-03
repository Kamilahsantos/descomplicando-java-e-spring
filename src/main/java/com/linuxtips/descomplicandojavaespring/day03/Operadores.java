package com.linuxtips.descomplicandojavaespring.day03;

public class Operadores {

    public static void main(String[] args) {

        //atribuicao
        int idade = 25;
        System.out.println("valor atribuido a idade   " + idade);

        //matematicos
        int soma = 25 + 5;
        System.out.println("resultado da soma   " + soma);
        int multiplicacao = soma * 2;
        System.out.println("resultado da multiplicacao    " + soma);
        int divisao = multiplicacao / 2;
        System.out.println("resultado da divisao    " + soma);
        int modulo = divisao % 4;
        System.out.println("resultado do  modulo    " + modulo);

        //incremento e decremento
        int incremento = 15;
        System.out.println("Valor original antes do incremente= " + incremento);
        incremento++;
        System.out.println("Valor apos o incremento++ = " + incremento);


        int decremento = 20;
        System.out.println("Valor original antes do decremento= " + decremento);
        decremento--;
        System.out.println("Valor apos o decremento++ = " + decremento);


        //operadores de igualdade
        long valor1 = 1L;
        long valor2 = 1L;

        if(valor1 == valor2){
            System.out.println("São iguais");
        } else {
            System.out.println("São diferentes");
        }

        double valor3 = 10.2;
        double valor4 = 100.2;

        if(valor3 != valor4){
            System.out.println("São diferentes");
        } else {
            System.out.println("São iguais");
        }

        //operadores relacionais
        int primeiroValor = 1234;
        int segundoValor = 1233;

        if (primeiroValor > segundoValor) {
            System.out.println(primeiroValor + "  é maior que "+  segundoValor);
        }

        if (primeiroValor >= segundoValor) {
            System.out.println(primeiroValor + "  é maior ou igual que "+  segundoValor);

        }

        if (primeiroValor < segundoValor) {
            System.out.println(primeiroValor + "  é menor que "+  segundoValor);
        }

        if (primeiroValor <= segundoValor) {
            System.out.println(primeiroValor + "  é menor ou igual "+  segundoValor);
        }

        //operadores lógicos
        boolean verdadeiro = true;
        boolean falso = false;

        System.out.println(verdadeiro || falso);
        System.out.println(verdadeiro && falso);


    }

}
