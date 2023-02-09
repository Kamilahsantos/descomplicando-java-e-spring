package com.linuxtips.descomplicandojavaespring.day07.heranca;

import com.linuxtips.descomplicandojavaespring.day07.heranca.PessoaDesenvolvedora;

public class PessoaDesenvolvedoraFrontEnd extends PessoaDesenvolvedora {

    public PessoaDesenvolvedoraFrontEnd(String nome, String stack, Double salario) {
        super(nome, stack, salario);
    }

    @Override
    public void codar() {
        super.codar();
    }
}
