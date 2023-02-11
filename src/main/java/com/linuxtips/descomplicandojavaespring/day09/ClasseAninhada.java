package com.linuxtips.descomplicandojavaespring.day09;

public class ClasseAninhada {

    private ClasseAninhada() {

    }

    private static class ClasseRealmenteAninhada {
        public static final ClasseAninhada classeAninhada = new ClasseAninhada();
    }

    public static ClasseAninhada getInstance() {
        return ClasseRealmenteAninhada.classeAninhada;
    }
}
