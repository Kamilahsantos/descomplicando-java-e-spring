package com.linuxtips.descomplicandojavaespring.day09.enums;


public enum DescontoEnum {

    ALUNA(10), FUNCIONARIO(20), EXTERNO(5);
    int valor;

    DescontoEnum(int valor) {
        this.valor = valor;
    }

    public static void main(String[] args) {

        for (DescontoEnum descontoEnum : DescontoEnum.values()) {
            System.out.println("tipos de desconto " + descontoEnum + "valor desconto " + descontoEnum.valor);

        }


    }

}




