package com.linuxtips.descomplicandojavaespring.estudanteapi.service;


import com.linuxtips.descomplicandojavaespring.estudanteapi.exception.EstudanteDuplicadoException;
import com.linuxtips.descomplicandojavaespring.estudanteapi.exception.EstudanteNaoEncontradoException;
import com.linuxtips.descomplicandojavaespring.estudanteapi.model.Estudante;
import com.linuxtips.descomplicandojavaespring.estudanteapi.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudanteService {


    @Autowired
    private EstudanteRepository estudanteRepository;


    public Estudante criarEstudante(Estudante estudante) throws EstudanteDuplicadoException {
        try {
            return estudanteRepository.save(estudante);

        } catch (Exception e) {
            throw new EstudanteDuplicadoException("Estudante com mesmo nome já cadastrado");
        }
    }


    public List<Estudante> listarEstudantes() {
        return estudanteRepository.findAll();
    }


    public Optional<Estudante> buscarEstudantePeloId(Long id) throws EstudanteNaoEncontradoException {

        if (estudanteRepository.findById(id).isEmpty()) {
            throw new EstudanteNaoEncontradoException(id);
        }
        return estudanteRepository.findById(id);
    }


    public ResponseEntity<Estudante> atualizarEstudantePeloId(Estudante estudante, Long id) {
        return estudanteRepository.findById(id).map(estudanteToUpdate -> {
            estudanteToUpdate.setCurso(estudante.getCurso());
            estudanteToUpdate.setEndereco(estudante.getEndereco());
            estudanteToUpdate.setNome(estudante.getNome());
            Estudante updated = estudanteRepository.save(estudanteToUpdate);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }


    public ResponseEntity<Object> excluirEstudantePeloId(Long id) {
        return estudanteRepository.findById(id).map(estudanteToDelete -> {
            estudanteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Estudante> buscarEstudantePeloNome(String nome) {
        return estudanteRepository.findByName(nome).map(estudante -> ResponseEntity.ok().body(estudante)).orElse(ResponseEntity.notFound().build());

    }

    //TODO desafio: adicione resposta de 404 quando nao achar nenhum dentro desse filtro
    public List<Estudante> listarEstudantesPeloCurso(String curso) {
        return estudanteRepository.findBycurso(curso);
    }

    public List<Estudante> listarEstudantesPeloComecoDoNome(String comecoNome) {
        return estudanteRepository.findByNomeStartingWith(comecoNome);
    }


    public List<Estudante> listarEstudantesPeloComecoDoNomeECurso(String comecoNome, String curso) {
        return estudanteRepository.findByNomeStartingWithAndCurso(comecoNome, curso);
    }


    public List<Estudante> listarEstudantesPeloEndereco(String endereco) {
        return estudanteRepository.findByEnderecoStartingWithOrderByEnderecoDesc(endereco);
    }


    public List<Estudante> listarPrimeirosEstudantes(Long id) {
        return estudanteRepository.findByIdLessThanEqual(id);
    }


}
