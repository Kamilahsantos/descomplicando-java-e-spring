package com.linuxtips.descomplicandojavaespring.day10.ListJava;

import java.util.ArrayList;
import java.util.Vector;

public class VectorListCollections {

    public static void main(String[] args) {

        Vector<Integer> meuVector = new Vector<>();
        for (int i = 1; i <= 10; i++)
            meuVector.add(i);

        System.out.println( meuVector.elementAt(2));
        System.out.println(meuVector.firstElement());
        meuVector.clear();
        System.out.println(meuVector);

    }


}
