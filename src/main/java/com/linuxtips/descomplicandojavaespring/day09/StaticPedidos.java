package com.linuxtips.descomplicandojavaespring.day09;

public class StaticPedidos {
  private String id;
  public static int pedidosFeitos;
  protected   static final String status = "PEDIDO_CONCLUIDO";


  public StaticPedidos(String id){
      this.id= id;
      pedidosFeitos++;
  }

  static void  completarPedido(){
      pedidosFeitos++;
      System.out.println("Pedido atualizado com o status  "+ status+
              "  já tivemos "+ pedidosFeitos + "  essa semana");
  }
}
