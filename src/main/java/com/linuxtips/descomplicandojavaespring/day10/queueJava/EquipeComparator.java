package com.linuxtips.descomplicandojavaespring.day10.queueJava;

import java.util.Comparator;


//ordena por uma determinada prioridade e nao por fifo
public class EquipeComparator implements Comparator<Equipe> {


    @Override
    public int compare(Equipe equipe1, Equipe equipe2) {
        if (equipe1.saldoDepontos < equipe2.saldoDepontos)
            return 1;

        else if (equipe1.saldoDepontos > equipe2.saldoDepontos)
            return -1;
        return 0;

    }

}




