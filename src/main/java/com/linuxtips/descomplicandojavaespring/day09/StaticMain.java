package com.linuxtips.descomplicandojavaespring.day09;

import java.io.IOException;

public class StaticMain {

    public static void main(String[] args) {

        StaticPedidos staticPedidos = new StaticPedidos("1234");
        StaticPedidos.completarPedido();
        StaticPedidos.completarPedido();
        StaticPedidos.completarPedido();
        StaticPedidos.completarPedido();


    }
}
