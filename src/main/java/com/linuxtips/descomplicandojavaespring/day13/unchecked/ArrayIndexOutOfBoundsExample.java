package com.linuxtips.descomplicandojavaespring.day13.unchecked;


import java.io.FileNotFoundException;

public class ArrayIndexOutOfBoundsExample {
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException {

        try {
            int[] array = {1, 2, 3, 4, 5,6,7,8,9};
            System.out.println(array[100]);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Não foi possível acessar essa posição do Array");

        }finally {
            System.out.println("Passou aqui");

        }
    }
    }


