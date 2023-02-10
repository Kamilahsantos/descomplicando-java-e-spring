package com.linuxtips.descomplicandojavaespring.day08;

import java.io.File;
import java.util.Scanner;

public class ValidadorNotaFiscal {
    public static void main(String[] args) throws Exception
    {
        File file = new File("/Users/kamilasantos/Downloads/descomplicando-java-e-spring 2/nota-fiscal-1234.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine())
            System.out.println(sc.nextLine());
    }
}
