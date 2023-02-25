package com.linuxtips.descomplicandojavaespring.day14.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaExample {

    public static void main(String[] args) {
        //pequeno bloco de codigo que recebe parametros e retorna um valor
        //sao semelhantes aos metodos
        // mas nao precisam de um nome e pode estar dentro do corpo de um outro metodo

        List<String> curso = Arrays.asList("Java", "Linux", "Tips", "Spring");
        List<String> java = curso.stream().filter(s -> s.equals("Jaca")).
                collect(Collectors.toList());
        System.out.println(java);

    }

}
