package com.linuxtips.descomplicandojavaespring.day10;

import java.util.ArrayList;

public class ArrayListCollections {

    public static void main(String[] args) {

        ArrayList<Integer> meuArrayList = new ArrayList<>();
        for (int i = 1; i <= 5; i++)
            meuArrayList.add(i);

        meuArrayList.remove(1);
        System.out.println(meuArrayList);
        System.out.println(meuArrayList.get(3));
        System.out.println(meuArrayList.isEmpty());
        System.out.println(meuArrayList.contains(3));
        System.out.println(meuArrayList.clone());
        System.out.println(meuArrayList.indexOf(3));
        meuArrayList.clear();
        System.out.println(meuArrayList);

    }


}
