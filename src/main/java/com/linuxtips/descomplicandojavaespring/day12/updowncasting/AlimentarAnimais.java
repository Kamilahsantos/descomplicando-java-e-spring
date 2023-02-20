package com.linuxtips.descomplicandojavaespring.day12.updowncasting;

public class AlimentarAnimais {
    //essa classe nao tem responsabilidade de saber qual animal esta na lista
    //aqui usamos o polimorfismo
//    public static void alimentar(Animal animal) {
//        animal.comer();
//    }

    //downcasting
    public static void alimentar(Animal animal) {
      animal.comer();
      //so queremos fazer downcasting do que for do tipo Cachorro
      if (animal instanceof Cachorro){
          ((Cachorro) animal).latir();
      }
   }
}
