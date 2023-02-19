package com.linuxtips.descomplicandojavaespring.day10.map;

import java.util.Hashtable;

public class HashTableCollections {

    public static void main(String[] args) {

        //chave valor
        //nao permite valores nulos
        //nao permite valores duplicados

        Hashtable<String, Double> notas = new Hashtable<String, Double>();
        notas.put("Lógica de programacao", 7.8);
        notas.put("Orientacao a objetos", 9.5);
        notas.put("Banco de dados", 7.2);
        System.out.println(notas);
        System.out.println(notas.values());
        System.out.println(notas.get("Banco de dados"));
        System.out.println(notas.replace("Banco de dados",10.0));
        System.out.println(notas.get("Banco de dados"));
        System.out.println(notas.putIfAbsent("Java",10.0));
        System.out.println(notas);




    }

}