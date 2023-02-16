package com.linuxtips.descomplicandojavaespring.day10.queueJava;

public class Equipe {

    public Equipe(String nome, int saldoDePontos) {
        this.nome = nome;
        this.saldoDePontos = saldoDePontos;
    }

    public String nome;
    public int saldoDePontos;


    public String toString(){
      return "Equipe "+ nome+ "está com a pontuação "+ saldoDePontos;
    }


}
