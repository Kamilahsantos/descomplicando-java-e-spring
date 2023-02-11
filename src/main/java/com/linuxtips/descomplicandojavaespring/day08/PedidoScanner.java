package com.linuxtips.descomplicandojavaespring.day08;

import java.util.Scanner;

public class PedidoScanner {

    public static void main(String[] args) {

        System.out.println("Por favor, insira o código do produto");

        Scanner scanner = new Scanner(System.in);

        String codigo = scanner.nextLine();
        System.out.println("Por favor, insira a quantidade de itens desse produto");
        Integer quantidade = scanner.nextInt();


        System.out.println("Digite o valor do produto");

        Integer valor = scanner.nextInt();

        int total = valor * quantidade;

        System.out.println("O valor total da sua compra é  " + total);





    }
}