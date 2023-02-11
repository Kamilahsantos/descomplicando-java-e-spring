package com.linuxtips.descomplicandojavaespring.day08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class NotaFiscal {

    public static void main(String[] args) throws IOException {

        System.out.println("Por favor, insira o código do produto");

        Scanner scanner = new Scanner(System.in);

        String codigo = scanner.nextLine();
        System.out.println("Por favor, insira a quantidade de itens desse produto");
        Integer quantidade = scanner.nextInt();


        System.out.println("Digite o valor do produto");

        Integer valor = scanner.nextInt();

        int total = valor * quantidade;

        System.out.println("O valor total da sua compra é  " + total);

        System.out.println("Aguarde um momento....Estamos emitindo sua nota fiscal");

        Path fileName = Path.of(
                "/Users/kamilasantos/Downloads/descomplicando-java-e-spring 2/nota-fiscal-"+codigo+".txt");

        String text = "Código do produto:  " + codigo +  " Qtde:  " + quantidade + " valor do produto:  " + valor +"\n"
                + " total da compra:  " + total + "";

        Files.writeString(fileName, text);

        String file_content = Files.readString(fileName);

        System.out.println(file_content);



    }
}
