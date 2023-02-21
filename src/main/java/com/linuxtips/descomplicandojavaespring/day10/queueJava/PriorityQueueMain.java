package com.linuxtips.descomplicandojavaespring.day10.queueJava;


import java.util.PriorityQueue;

public class PriorityQueueMain {

    public static void main(String[] args) {

        Equipe equipe1 = new Equipe("Equipe1", 230);
        Equipe equipe2 = new Equipe("Equipe2", 900);
        Equipe equipe3 = new Equipe("Equipe3", 700);
        Equipe equipe4 = new Equipe("Equipe4", 100);
        Equipe equipe5 = new Equipe("Equipe5", 6789);

        PriorityQueue<Equipe> priorityQueue = new PriorityQueue<Equipe>
                (5, new EquipeComparator());

        priorityQueue.add(equipe1);
        priorityQueue.add(equipe2);
        priorityQueue.add(equipe3);
        priorityQueue.add(equipe4);
        priorityQueue.add(equipe5);

        for (Equipe equipe : priorityQueue) {

            System.out.println(equipe);


        }


    }
}

