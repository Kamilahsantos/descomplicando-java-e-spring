package com.linuxtips.descomplicandojavaespring.estudanteapi;


import com.linuxtips.descomplicandojavaespring.estudanteapi.model.DadosBancarios;
import com.linuxtips.descomplicandojavaespring.estudanteapi.model.Estudante;
import com.linuxtips.descomplicandojavaespring.estudanteapi.model.enums.TipoContaBancaria;
import com.linuxtips.descomplicandojavaespring.estudanteapi.repository.EstudanteRepository;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Sucesso - Deve salvar estudante na base com sucesso")
    void DeveSalvarEstudanteNaBaseComSucesso() {

        Estudante estudanteSalvo = this.estudanteRepository.save(buildMockEstudante());
        assertNotNull(estudanteSalvo);
        assertEquals("java", estudanteSalvo.getCurso());
    }


    @DisplayName("Sucesso - Deve listar todos os estudantes na base com sucesso")
    @Test
    void deveRetornarListaDeEstudantesCadastradosNaBaseComSucesso() {

        estudanteRepository.save(buildMockEstudante());

        List<Estudante> estudantes = this.estudanteRepository.findAll();
        assertEquals(1, estudantes.size());
    }


    @DisplayName("Sucesso - Deve excluir um estudante com sucesso")
    @Test
    void deveExcluirUmEstudanteComSucesso() {
        this.estudanteRepository.deleteById(1L);
        Optional<Estudante> estudante = this.estudanteRepository.findById(1L);
        assertFalse(estudante.isPresent());
    }


    @DisplayName("Sucesso - Deve buscar um estudante pelo id com sucesso")
    @Test
    void deveBuscarUmEstudantePeloIdComSucesso() {
        estudanteRepository.save(buildMockEstudante());

        Optional<Estudante> estudante = this.estudanteRepository.findById(1L);
        assertTrue(estudante.isPresent());
    }

    @DisplayName("Sucesso - Deve buscar um estudante pelo nome com sucesso")
    @Test
    void deveBuscarUmEstudantePeloNomeComSucesso() {
        estudanteRepository.save(buildMockEstudante());

        Optional<Estudante> estudante = this.estudanteRepository.findByName("aluno");
        assertTrue(estudante.isPresent());
    }

    @DisplayName("Sucesso - Deve buscar um estudante pelo nome e curso com sucesso")
    @Test
    void deveBuscarUmEstudantePeloNomeECursoComSucesso() {
        estudanteRepository.save(buildMockEstudante());

        List<Estudante> estudantes = this.estudanteRepository.findByNomeStartingWithAndCurso("a", "java");
        assertEquals(1, estudantes.size());
    }

    private Estudante buildMockEstudante() {
        Estudante estudante = new Estudante();
        DadosBancarios dadosBancarios = new DadosBancarios();
        dadosBancarios.setTipoContaBancaria(TipoContaBancaria.valueOf("CORRENTE"));
        dadosBancarios.setDigito(1);
        dadosBancarios.setAgencia(1234);
        dadosBancarios.setConta(123);
        estudante.setId(1L);
        estudante.setNome("aluno");
        estudante.setCurso("java");
        estudante.setEndereco("rua");
        estudante.setDadosBancarios(dadosBancarios);
        return estudante;
    }
}
