package com.linuxtips.descomplicandojavaespring.day07.heranca;

public class PessoaDesenvolderaBackend extends PessoaDesenvolvedora {

    public PessoaDesenvolderaBackend(String nome,String stack, Double salario) {
        super(nome,stack,salario);
    }

    @Override
    public void codar() {
        super.codar();
    }
}
