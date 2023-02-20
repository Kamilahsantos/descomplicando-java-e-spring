package com.linuxtips.descomplicandojavaespring.day12;

//Esse tipo de typecasting ocorre quando a conversão é feita de forma automática
public class Widening {

    public static void main(String[] args) {

        int variavelInt = 123;
        long variavelLong = variavelInt;

        System.out.println(variavelInt);
        System.out.println(variavelLong);

        //nesse tipo de conversao o valor é armazenado em um container maior
        // e todo o espaco extra existente a esquerda é preenchido com zeros

        //quando passamos de valores inteiros para valores com ponto flutuante
        //ocorre a mesma coisa
        //nao ocorre perca de informacao
        float variavelFloat =  variavelLong;
        double  variavelDouble = variavelLong;

        System.out.println(variavelFloat);
        System.out.println(variavelDouble);

        // como estamos indo para um container maior nao temos perca de informacoes
        // byte -> short -> int -> long-> float double





    }

}
