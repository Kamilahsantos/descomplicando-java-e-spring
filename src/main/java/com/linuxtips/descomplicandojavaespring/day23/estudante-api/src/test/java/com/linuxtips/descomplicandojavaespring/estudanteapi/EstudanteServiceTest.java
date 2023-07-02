package com.linuxtips.descomplicandojavaespring.estudanteapi;


import com.linuxtips.descomplicandojavaespring.estudanteapi.exception.EstudanteDuplicadoException;
import com.linuxtips.descomplicandojavaespring.estudanteapi.exception.EstudanteNaoEncontradoException;
import com.linuxtips.descomplicandojavaespring.estudanteapi.model.DadosBancarios;
import com.linuxtips.descomplicandojavaespring.estudanteapi.model.Estudante;
import com.linuxtips.descomplicandojavaespring.estudanteapi.model.enums.TipoContaBancaria;
import com.linuxtips.descomplicandojavaespring.estudanteapi.repository.EstudanteRepository;
import com.linuxtips.descomplicandojavaespring.estudanteapi.service.EstudanteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class EstudanteServiceTest {

    @Mock
    private EstudanteRepository estudanteRepository;

    @InjectMocks
    private EstudanteService estudanteService;

    @Test
    @DisplayName("Sucesso - Deve salvar estudante na base com sucesso")
    void deveSalvarUmNovoEstudanteComSucesso() throws EstudanteDuplicadoException {
        Estudante estudante = this.buildMockEstudante();
        this.estudanteService.criarEstudante(estudante);
        verify(this.estudanteRepository).save(estudante);

    }

    //TODO desafio: validar via teste a exception estudante duplicado  - dica assertThrows

    @Test
    @DisplayName("Sucesso - Deve salvar estudante na base com sucesso sem lançar exceção")
    void deveSalvarUmNovoEstudanteComSucessoSemLancarExcecao() throws EstudanteDuplicadoException {
        Estudante estudante = this.buildMockEstudante();
        this.estudanteService.criarEstudante(estudante);
        assertDoesNotThrow(() -> {
            estudanteService.criarEstudante(estudante);
        });

    }

    @Test
    @DisplayName("Sucesso - Deve retornar a lista de estudantes com sucesso")
    void deveRetornarAListadeEstudantesComsucesso() {
        Estudante estudante = this.buildMockEstudante();
        when(estudanteRepository.findAll()).thenReturn(List.of(estudante));
        List<Estudante> estudantes = this.estudanteService.listarEstudantes();
        assertEquals(1, estudantes.size());
        verify(this.estudanteRepository).findAll();
    }

    @Test
    @DisplayName("Sucesso - Deve buscar um estudante pelo id com sucesso")
    void deveBuscarUmEstudantePeloIdComSucesso() throws EstudanteNaoEncontradoException {
        Estudante estudante = this.buildMockEstudante();
        when(estudanteRepository.findById(1L)).thenReturn(Optional.of(estudante));
        var estudanteBase = this.estudanteService.buscarEstudantePeloId(1L);
        assertEquals(estudante.getId(), estudanteBase.get()
                .getId());

    }

    @Test
    @DisplayName("Erro - Deve lançar exception ao buscar estudante pelo id")
    void deveBuscarUmEstudantePeloIdERetornarException() throws EstudanteNaoEncontradoException {
        when(estudanteRepository.findById(200L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(EstudanteNaoEncontradoException.class,
                () -> estudanteService.buscarEstudantePeloId(200L));
        assertEquals("Estudante com o id  " + 200L + " nao localizado na base", exception.getMessage());
        verify(this.estudanteRepository).findById(200L);

    }

    @Test
    @DisplayName("Sucesso - Deve buscar um estudante pelo nome com sucesso")
    void deveBuscarUmEstudantePeloNomeComSucesso()  {
        Estudante estudante = this.buildMockEstudante();
        when(estudanteRepository.findByName("al")).thenReturn(Optional.of(estudante));
        var estudanteBase = this.estudanteService.buscarEstudantePeloNome("al");
        assertEquals("aluno", estudanteBase.getBody().getNome());

    }


    //TODO desafio  validar se o estudante foi atualizado  - dica: assertNotEquals

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