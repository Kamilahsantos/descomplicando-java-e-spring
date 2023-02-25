package com.linuxtips.descomplicandojavaespring.day13.checked;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileNotFoundExample {

    public static void main(String[] args) throws FileNotFoundException {

        FileInputStream fileInputStream = null;

        try {


            fileInputStream = new FileInputStream(
                    "invalidpath.txt");
        }

        catch (FileNotFoundException e) {

            System.out.println("Arquivo não localizado na caminho informado");
        }

    }
}
