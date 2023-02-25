package com.linuxtips.descomplicandojavaespring.day14.streams;

import java.util.Arrays;
import java.util.List;

public class Reduce {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int listaReduzida = integerList

                .stream()
//reduz a lista para um unico elemento
                //imprime o elemento maior
//                .reduce(0, Integer::max);
                //soma todos os itens
//                .reduce(0, Integer::sum);
                //imprime o menor numero
                //Realiza uma redução nos elementos deste fluxo, usando o valor de identidade fornecido e uma função de acumulação associativa, e retorna o valor reduzido
                .reduce(0, Integer::min);

        System.out.println(listaReduzida);

    }
}
