package com.linuxtips.descomplicandojavaespring.day11;


public class toStringMain {
    public static void main(String[] args) {

        Funcionaria funcionaria = new Funcionaria();
        funcionaria.setCargo("tech lead");
        funcionaria.setIdade(25);
        funcionaria.setNome("kamila");
        funcionaria.setSetor("bancario");
        funcionaria.setSalario(300000.0);

        System.out.println(funcionaria);

        System.out.println(funcionaria.getNome().equals("java"));
        var setorHashCode = String.valueOf(funcionaria.getSetor().hashCode());
        var setorHashCodeNovo = String.valueOf("bancario".hashCode());
        System.out.println(setorHashCode.equals(setorHashCodeNovo.hashCode()));

    }
}
