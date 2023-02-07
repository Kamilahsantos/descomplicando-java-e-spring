package com.linuxtips.descomplicandojavaespring.day06;

public class Objetos {

    public static void main(String[] args) {

Estudante kamilaCode = new Estudante();
kamilaCode.setNome("Kamila");
kamilaCode.setStack("Java e Spring");
kamilaCode.estudar();
kamilaCode.dormir();
System.out.println(kamilaCode.getNome());
System.out.println(kamilaCode.getStack());


    }
}

