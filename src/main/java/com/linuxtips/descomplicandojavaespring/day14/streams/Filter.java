package com.linuxtips.descomplicandojavaespring.day14.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    public static void main(String[] args) {

        List<String> languages = Arrays.asList("Java", "Linux", "Tips", "Spring");

        //filter -> para retornar elementos que passam no filtro indicado
        List<String> languageFilter = languages.stream().filter(s -> s.endsWith("s")).collect(Collectors.toList());

        System.out.println(languageFilter);





    }
}
