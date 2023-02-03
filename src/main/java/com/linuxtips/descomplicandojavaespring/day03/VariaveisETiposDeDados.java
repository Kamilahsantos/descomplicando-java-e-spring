package com.linuxtips.descomplicandojavaespring.day03;

public class VariaveisETiposDeDados {

    public static void main(String[] args) {

        //valores inteiros ou negativos requer 8 bits, máximo é 127 e mínimo é 128
        byte meuByte = 127;
        System.out.println("meu byte   " + meuByte);

        //dobro de bit do bit, min de -32.768  e max 32.767.
        short meuShort = 32767;
        System.out.println("meu short   " +meuShort);

        //usa 32 bits, minimo de -2.147.483.648 e max de 2.147.483.647
        int idade = 25;
        System.out.println("meu int   " +idade);

        //64 bits
        long meuLong = 10L;
        System.out.println("meu long   "+ meuLong);


        //dupla precisao, 64 bits
        double salario = 102.51;
        System.out.println("meu double    "+ salario);

        //precisao simples, 32 bits,
        float salarioFloat = 102.52F;
        System.out.println("meu float   "+salarioFloat);

        //16 bits, um unico unicode
        char letra = 'A';
        System.out.println("meu char    "+letra);

        //1 bit
        boolean javaELegal = true;
        System.out.println("meu boolean   "+ javaELegal);


    }

}
