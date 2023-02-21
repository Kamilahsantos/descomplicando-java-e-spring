package com.linuxtips.descomplicandojavaespring.day10.queueJava;

public class Equipe {


    public Equipe(String nome, int saldoDepontos) {
        this.nome = nome;
        this.saldoDepontos = saldoDepontos;
    }

    public String nome;
   public int saldoDepontos;

    @Override
    public String toString() {
        return "Equipe "+  nome  + " está com a pontuação  "+ saldoDepontos;
    }
}
