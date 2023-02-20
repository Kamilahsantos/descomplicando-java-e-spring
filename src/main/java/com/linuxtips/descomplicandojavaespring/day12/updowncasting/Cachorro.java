package com.linuxtips.descomplicandojavaespring.day12.updowncasting;

public class Cachorro  extends Animal{

    @Override
    public void comer() {
        super.comer();
    }

    //downcasting
    public void latir(){
        System.out.println("latir");
    }
}
