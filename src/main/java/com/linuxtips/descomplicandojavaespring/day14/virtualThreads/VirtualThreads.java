package com.linuxtips.descomplicandojavaespring.day14.virtualThreads;

import java.util.Random;

//threads - instância da CPU da máquina virtual Java, e que tem associada um trecho de código que será executado, e uma área de memória.
// sao criadas na JVM e não são 1:1 com as threads do sistema operacional
// a jvm fica responsavel por fazer esse gerenciamento das threads
public class VirtualThreads {

    public static void main(String[] args) {
        //flag que controla o uso das threads virtuais
        boolean threadsVirtuaisHabilitadas = false;
        System.out.println("Threads virtuais ligadas ? " + threadsVirtuaisHabilitadas);

        long horaDeInicio = System.currentTimeMillis();
        Random random = new Random();
        //cria numeros inteiros aleatorios ate o valor de bound
        Runnable runnable = () -> {
            Integer i = random.nextInt(999999999);
        };
        for (int i = 0; i < 1000; i++) {
            if (threadsVirtuaisHabilitadas) {
                Thread.startVirtualThread(runnable);

            } else {
                //caso esteja falso serão usadas as threads normais
                Thread thread = new Thread(runnable);
                thread.start();

            }
        }

        long horaDeFim = System.currentTimeMillis();
        long tempoGasto = horaDeFim - horaDeInicio;
        System.out.println("Tempo gasto em execução: " + tempoGasto);

    }


}
