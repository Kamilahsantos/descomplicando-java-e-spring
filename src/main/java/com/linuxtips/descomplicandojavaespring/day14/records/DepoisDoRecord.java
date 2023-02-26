package com.linuxtips.descomplicandojavaespring.day14.records;

public record DepoisDoRecord(String nome, String endereco, String telefone) {
}

// oficialmente no Java 16
//um record é uma classe que armazena dados, ela é imutavel
//ja possui por padrão so metodos equals, hashCode e toString
//diminui escrita de codigo boiler plate e do lombok


