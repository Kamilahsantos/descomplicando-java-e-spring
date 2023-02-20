package com.linuxtips.descomplicandojavaespring.day12.upcasting;

import java.util.ArrayList;
import java.util.List;

import static com.linuxtips.descomplicandojavaespring.day12.upcasting.AlimentarAnimais.alimentar;

public class UpcastingMain {

    public static void main(String[] args) {
//         Passaro passaro = new Passaro();
//         // animal = (Animal) passaro;
//         Animal animal = passaro;
//
//         passaro.comer();
//         animal.comer();

        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Passaro());
        animalList.add(new Cachorro());

        for(Animal animal: animalList){
            alimentar(animal);
        }




    }
    }
