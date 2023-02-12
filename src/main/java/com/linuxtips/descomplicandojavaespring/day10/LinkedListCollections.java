package com.linuxtips.descomplicandojavaespring.day10;

import java.util.LinkedList;

public class LinkedListCollections {

    public static void main(String[] args) {

        LinkedList<Integer> minhaLinkedList = new LinkedList<>();
        for (int i = 1; i <= 5; i++)
            minhaLinkedList.add(i);
        System.out.println(minhaLinkedList);
        System.out.println(minhaLinkedList.pop());
        System.out.println(minhaLinkedList.peek());
        System.out.println(minhaLinkedList.poll());
        System.out.println(minhaLinkedList);
        minhaLinkedList.clear();
        System.out.println(minhaLinkedList);

    }


}
