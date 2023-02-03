package com.linuxtips.descomplicandojavaespring.day04;

import java.util.Scanner;

public class Repeticao {

    //for
    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {
            System.out.println("Nessa repeticao i está valendo  " + i);
        }


        //while
        Scanner in = new Scanner(System.in);
        var valorSecreto = 0;
        while (valorSecreto != 12345) {
            System.out.println("advinhe o valor secreto");
            valorSecreto = in.nextInt();
            if (valorSecreto == 12345) {
                System.out.println("Voce acertou o valor, parabens");
            } else {
                System.out.println("Não é esse o valor, tente novamente");
            }
        }


        //do-while
        int valor = 10;
        do {
            System.out.println(valor);
            valor++;
        } while (valor <= 50);
    }
}

