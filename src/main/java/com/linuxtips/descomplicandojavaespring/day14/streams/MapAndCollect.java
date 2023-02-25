package com.linuxtips.descomplicandojavaespring.day14.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapAndCollect {

    public static void main(String[] args) {


        List<String> listaString = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k");
        System.out.println(listaString);

        List<String> myIntegerList = listaString.stream()
                //visa retornar um stream com o resultado de uma operação que foi realizada com esse stream
                .map(String::valueOf)
                //para coletar o resultado das transformações feitas em um fluxo
                .collect(Collectors.toList());

        System.out.println(myIntegerList);
    }

}
