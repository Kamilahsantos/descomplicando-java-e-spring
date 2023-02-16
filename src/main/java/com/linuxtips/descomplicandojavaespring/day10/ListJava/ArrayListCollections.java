package com.linuxtips.descomplicandojavaespring.day10.ListJava;

import java.util.ArrayList;

public class ArrayListCollections {

    public static void main(String[] args) {

        // nos fornece arrays dinâmicos em Java
        // pode ser mais lento que os Arrays padrão
        ArrayList<Integer> meuArrayList = new ArrayList<>();

        for (int i = 1; i <= 10; i++)
            //adicionando itens no arrayList
            meuArrayList.add(i);

        //remove um item de um indice especifico
        meuArrayList.remove(1);
        System.out.println(meuArrayList);

        //retorna o que está localizado em um indice especifico
        System.out.println(meuArrayList.get(3));

        //retorna true ou false se o array list esta vazio
        System.out.println(meuArrayList.isEmpty());

        //valida se contem algum numero 3 no array
        System.out.println(meuArrayList.contains(3));
        System.out.println(meuArrayList.clone());
        System.out.println(meuArrayList.indexOf(3));
        meuArrayList.clear();
        System.out.println(meuArrayList);

    }


}
