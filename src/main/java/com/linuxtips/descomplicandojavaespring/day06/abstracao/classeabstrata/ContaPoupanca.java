package com.linuxtips.descomplicandojavaespring.day06.abstracao.classeabstrata;

class ContaPoupanca extends Conta {

    @Override
    public void consultarSaldo() {

        System.out.println("o saldo da sua conta poupanca é 0 ");
    }


    @Override
    public void fazerPix() {
        System.out.println("Deu ruim ");

    }


}
