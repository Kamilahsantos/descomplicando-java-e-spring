package com.linuxtips.descomplicandojavaespring.estudanteapi.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.linuxtips.descomplicandojavaespring.estudanteapi.model.enums.TipoContaBancaria;
import jakarta.persistence.*;

@Entity
@Table(name = "dados_bancarios")
public class DadosBancarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private Integer agencia;

    @Column(nullable = false, unique = true)
    private Integer conta;


    @Column(nullable = false)
    private Integer digito;


    @Column(nullable = false)
    private TipoContaBancaria tipoContaBancaria;


    @OneToOne(mappedBy = "dadosBancarios")
    @JsonBackReference
    private Estudante estudante;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getConta() {
        return conta;
    }

    public void setConta(Integer conta) {
        this.conta = conta;
    }

    public Integer getDigito() {
        return digito;
    }

    public void setDigito(Integer digito) {
        this.digito = digito;
    }

    public TipoContaBancaria getTipoContaBancaria() {
        return tipoContaBancaria;
    }

    public void setTipoContaBancaria(TipoContaBancaria tipoContaBancaria) {
        this.tipoContaBancaria = tipoContaBancaria;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }


}
