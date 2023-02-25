package com.linuxtips.descomplicandojavaespring.day14.streams;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    public static void main(String[] args) {

        //filter -> para retorna elementos que passam em um filtro indicado
        List<String> curso = Arrays.asList("Java", "Linux", "Tips", "Spring");
        List<String> terminaComS = curso.stream().filter(s -> s.startsWith("J")).
                collect(Collectors.toList());
        System.out.println(terminaComS);






    }
}
