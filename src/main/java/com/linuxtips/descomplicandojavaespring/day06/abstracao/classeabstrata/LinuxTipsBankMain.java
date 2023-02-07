package com.linuxtips.descomplicandojavaespring.day06.abstracao.classeabstrata;

public class LinuxTipsBankMain {

    public static void main(String[] args) {

        System.out.println("seja bem vinde ao linux tips bank");
        ContaCorrente ccKamila = new ContaCorrente();
        ccKamila.consultarSaldo();
        ccKamila.fazerPix();

        ContaPoupanca cpKamila = new ContaPoupanca();
        cpKamila.consultarSaldo();


    }
}
