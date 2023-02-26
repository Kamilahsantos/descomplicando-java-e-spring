package com.linuxtips.descomplicandojavaespring.day14.records;

public class Main {

    public static  void main(String[] args){
        DepoisDoRecord depoisDoRecord = new DepoisDoRecord("Kamila", "rua do java", "12345678");
        System.out.println(depoisDoRecord.endereco());
        System.out.println(depoisDoRecord.telefone().equals("12345678"));
        System.out.println(depoisDoRecord.endereco());

    }
}
