package com.linuxtips.descomplicandojavaespring.estudanteapi;


import com.linuxtips.descomplicandojavaespring.estudanteapi.model.DadosBancarios;
import com.linuxtips.descomplicandojavaespring.estudanteapi.model.Estudante;
import com.linuxtips.descomplicandojavaespring.estudanteapi.model.enums.TipoContaBancaria;
import com.linuxtips.descomplicandojavaespring.estudanteapi.repository.EstudanteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class EstudanteRepositoryTest {

    @Autowired
    private EstudanteRepository estudanteRepository;


    @Test
    void DeveSalvarEstudanteNaBase() {
        Estudante estudante = new Estudante();
        DadosBancarios dadosBancarios = new DadosBancarios();
        dadosBancarios.setTipoContaBancaria(TipoContaBancaria.valueOf("CORRENTE"));
        dadosBancarios.setDigito(1);
        dadosBancarios.setAgencia(1234);
        dadosBancarios.setConta(123);
        estudante.setNome("aluno");
        estudante.setCurso("java");
        estudante.setEndereco("rua");
        estudante.setDadosBancarios(dadosBancarios);

        Estudante estudanteSalvo = this.estudanteRepository.save(estudante);
        assertNotNull(estudanteSalvo);
        assertEquals("java", estudanteSalvo.getCurso());
    }

    @Test
    void deveRetornarListaDeEstudantes() {

        Estudante estudante = new Estudante();
        DadosBancarios dadosBancarios = new DadosBancarios();
        dadosBancarios.setTipoContaBancaria(TipoContaBancaria.valueOf("CORRENTE"));
        dadosBancarios.setDigito(1);
        dadosBancarios.setAgencia(1234);
        dadosBancarios.setConta(123);
        estudante.setNome("aluno");
        estudante.setCurso("java");
        estudante.setEndereco("rua");
        estudante.setDadosBancarios(dadosBancarios);

        estudanteRepository.save(estudante);


        List<Estudante> estudantes = this.estudanteRepository.findAll();
        assertEquals(1, estudantes.size());
    }

    @Test
    void deveExcluirumEstudante() {
        this.estudanteRepository.deleteById(1L);
        Optional<Estudante> estudante = this.estudanteRepository.findById(1L);
        assertFalse(estudante.isPresent());
    }

}
