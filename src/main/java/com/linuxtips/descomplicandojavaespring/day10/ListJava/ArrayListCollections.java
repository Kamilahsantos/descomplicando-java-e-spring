package com.linuxtips.descomplicandojavaespring.day10.ListJava;


import java.util.ArrayList;

public class ArrayListCollections {

    public static void main(String[] args) {

        //nos fornece arrays dinamicos em Java
        //pode ser mais lento que os arrays padrao
        //aumenta 50 % quando estiver cheio
        //quando aumenta o tamanho faz copia do array atual para um novo array com o mesmo tamanho

        ArrayList<Integer> meuArrayList = new ArrayList<>();

        for(int i= 1; i<=10; i++){
            //adicionando itens no arrayList
           meuArrayList.add(i);

        }

        //remove de um indice
        meuArrayList.remove(9);
        System.out.println(meuArrayList);

        //acessando um indice especifico
        System.out.println(meuArrayList.get(3));

        //retorna se esta vazio
        System.out.println(meuArrayList.isEmpty());

        //valida se encontra algum numero 3 no array
        System.out.println(meuArrayList.contains(3));
        //copia
        System.out.println(meuArrayList.clone());
        //qual o indice que esta localizado
        System.out.println(meuArrayList.indexOf(3));
        meuArrayList.clear();
        System.out.println(meuArrayList);
        System.out.println(meuArrayList.isEmpty());






    }

}
