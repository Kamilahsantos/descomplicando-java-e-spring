package com.linuxtips.descomplicandojavaespring.day12.upcasting;

public class AlimentarAnimais {
    //essa classe nao tem responsabilidade de saber qual animal esta na lista
    //aqui usamos o polimorfismo
    public static void alimentar(Animal animal) {
        animal.comer();
    }
}
