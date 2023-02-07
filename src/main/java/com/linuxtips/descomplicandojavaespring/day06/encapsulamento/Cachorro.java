package com.linuxtips.descomplicandojavaespring.day06.encapsulamento;

public class Cachorro {

    private Double peso;
    private Integer idade;

    public Double pesopublic;
    public Integer idadePublic;

    protected Double pesoProtected;
    protected Integer idadeProtected;


    public String latir() {
        return "AuAU";

    }

    protected String dormir() {
        return "zzzzz";
    }

    private String comer() {
        return "hora da racao";

    }
}
