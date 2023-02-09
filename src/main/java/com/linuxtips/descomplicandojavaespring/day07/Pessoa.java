package com.linuxtips.descomplicandojavaespring.day07;

public class Pessoa {

    public static void main(String[] args) {

        PessoaDesenvolderaBackend pessoaDesenvolderaBackend =
                new PessoaDesenvolderaBackend("kamilabackend", "java e spring", 10000.0);
        pessoaDesenvolderaBackend.codar();



        PessoaDesenvolvedoraFrontEnd pessoaDesenvolvedoraFrontEnd =
                new PessoaDesenvolvedoraFrontEnd("kamilafrontend", "javaescripto", 10000.0);
        pessoaDesenvolvedoraFrontEnd.codar();


    }
}
