package com.linuxtips.descomplicandojavaespring.day11;


public class toStringMain {
    public static void main(String[] args) {

        Funcionaria funcionaria = new Funcionaria();
        funcionaria.setCargo("tech lead");
        funcionaria.setIdade(25);
        funcionaria.setNome("Kamila");
        funcionaria.setSetor("Bancario");
        funcionaria.setSalario(3726362375252.0);

        System.out.println(funcionaria);

        System.out.println(funcionaria.getNome().equals("kamila"));

        System.out.println(funcionaria.hashCode());
        System.out.println(funcionaria.getSetor().hashCode());
        System.out.println(funcionaria.getSalario().hashCode());
        System.out.println(funcionaria.getNome().hashCode());
        System.out.println(funcionaria.getCargo().hashCode());
        System.out.println(funcionaria.getIdade().hashCode());

        var setorHashCode = String.valueOf(funcionaria.getSetor().hashCode());
        var setorHashCodeNovo = String.valueOf("bancario".hashCode());
        System.out.println(setorHashCode.equals(setorHashCodeNovo));





    }
}
