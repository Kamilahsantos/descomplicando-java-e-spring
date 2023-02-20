package com.linuxtips.descomplicandojavaespring.day11;

import java.util.Objects;

public class Funcionaria {

    private Integer idade;
    private String nome;
    private String cargo;
    private String setor;
    private Double salario;

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionaria com o nome "+ nome+ " tem " + idade  + "  anos "
                + "tem o cargo  "+  cargo+ " trabalha no setor  "+  setor + " e recebe o salario de " + salario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionaria that = (Funcionaria) o;
        return Objects.equals(idade, that.idade) && Objects.equals(nome, that.nome) && Objects.equals(cargo, that.cargo) && Objects.equals(setor, that.setor) && Objects.equals(salario, that.salario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idade, nome, cargo, setor, salario);
    }
}
