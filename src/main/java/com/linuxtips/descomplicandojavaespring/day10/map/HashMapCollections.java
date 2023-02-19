package com.linuxtips.descomplicandojavaespring.day10.map;

import java.util.HashMap;

public class HashMapCollections {

    public static void main(String[] args) {

        //armazena chave valor
        //chave -> indicide
        //objeto -> valor
        //permite chaves nulas
        //nao garante a ordem

        HashMap<String, Double> notas = new HashMap<String, Double>();
        notas.put("Lógica de programacao", 7.8);
        notas.put("Orientacao a objetos", 9.5);
        notas.put("Banco de dados", 7.2);
        System.out.println(notas);


        System.out.println(notas.get("Banco de dados"));
        System.out.println(notas.getOrDefault("Banco do dados", 0.0));
        System.out.println(notas.put("Java", 10.0));
        System.out.println(notas);
        System.out.println(notas.containsKey("Java"));
        System.out.println(notas.containsValue(6.0));



    }

}