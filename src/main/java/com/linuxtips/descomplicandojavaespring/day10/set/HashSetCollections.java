package com.linuxtips.descomplicandojavaespring.day10.set;

import java.util.HashSet;

public class HashSetCollections {


    public static void main(String[] args) {

        //coleção de itens onde cada item é unico
        // implementa a interface SET
        // objetos são inseriods com base em seu código hash
        // elementos null tbm sao permitidos

        HashSet<String> linguagens = new HashSet<>();
        linguagens.add("Java");
        linguagens.add("Python");
        linguagens.add("Javascript");
        linguagens.add("Ruby");
        linguagens.add("Kotlin");
        linguagens.add("Rust");
        linguagens.add("Scala");

        System.out.println(linguagens);

        System.out.println(linguagens.contains("Kotlin"));

        System.out.println(linguagens.size());

        for(String i: linguagens){
            System.out.println(i);
        }





    }
}