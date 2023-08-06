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
    @DisplayName("sucesso - deve salvar estudante na base com sucesso")
    void DeveSalvarEstudanteNaBaseComSucesso(){

        Estudante estudanteSalvo = this.estudanteRepository.save(buildMockEstudante());
        assertNotNull(estudanteSalvo);
        assertEquals("java", estudanteSalvo.getCurso());
    }

    @Test
    @DisplayName("sucesso - deve listar todos os estudantes com sucesso")
    void DeveListarEstudantesCadastradoscomSucesso(){

        estudanteRepository.save(buildMockEstudante());
        List<Estudante> estudantes = this.estudanteRepository.findAll();
        assertEquals(1, estudantes.size());

    }

    @Test
    @DisplayName("sucesso - deve  excluir estudante na base com sucesso")
    void DeveExcluirEstudanteNaBaseComSucesso(){

        this.estudanteRepository.deleteById(1L);
        Optional<Estudante>  estudante = this.estudanteRepository.findById(1L);
        assertFalse(estudante.isPresent());
    }

    @Test
    @DisplayName("sucesso - deve buscar  estudante  pelo nome na base com sucesso")
    void DevebuscarEstudantePeloNomeNaBaseComSucesso(){

       this.estudanteRepository.save(buildMockEstudante());
        Optional<Estudante> estudante = this.estudanteRepository.findByName("aluno");
        assertTrue(estudante.isPresent());
    }


    @Test
    @DisplayName("sucesso - deve buscar  estudante  pelo nome e curso na base com sucesso")
    void DevebuscarEstudantePeloNomeECursoNaBaseComSucesso(){

        this.estudanteRepository.save(buildMockEstudante());
        List<Estudante> estudantes = this.estudanteRepository.findByNomeStartingWithAndCurso("a", "java");
        assertEquals(1, estudantes.size());

    }








    private Estudante buildMockEstudante(){
        Estudante estudante = new Estudante();
        DadosBancarios dadosBancarios = new DadosBancarios();
        dadosBancarios.setTipoContaBancaria
                (TipoContaBancaria.valueOf("CORRENTE"));
        dadosBancarios.setDigito(1);
        dadosBancarios.setAgencia(1234);
        dadosBancarios.setConta(1234);
        estudante.setId(1L);
        estudante.setNome("aluno");
        estudante.setCurso("java");
        estudante.setEndereco("rua");
        estudante.setDadosBancarios(dadosBancarios);
        return  estudante;
    }


}
