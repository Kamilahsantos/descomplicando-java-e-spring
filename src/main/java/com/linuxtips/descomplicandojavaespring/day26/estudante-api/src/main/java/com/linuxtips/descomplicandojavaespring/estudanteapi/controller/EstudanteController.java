package com.linuxtips.descomplicandojavaespring.estudanteapi.controller;


import com.linuxtips.descomplicandojavaespring.estudanteapi.model.Estudante;
import com.linuxtips.descomplicandojavaespring.estudanteapi.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;



    @PostMapping("/estudantes")
    @ResponseStatus(HttpStatus.CREATED)
    public Estudante criarEstudante(@RequestBody Estudante estudante) {
        return estudanteService.criarEstudante(estudante);
    }


    @GetMapping("/estudantes")
    @ResponseStatus(HttpStatus.OK)
    public List<Estudante> listarEstudantes() {
        return estudanteService.listarEstudantes();
    }


    @GetMapping("/estudantes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Estudante> buscarEstudantePeloId
            (@PathVariable(value = "id") Long id) {
        return estudanteService.buscarEstudantePeloId(id);

    }



    @PutMapping("/estudantes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Estudante> atualizarEstudantePeloId
            (@PathVariable(value = "id") Long id,
             @RequestBody Estudante estudante) {
        return estudanteService.atualizarEstudantePeloId(estudante, id);

    }


    @DeleteMapping("/estudantes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> excluirEstudantePeloId
            (@PathVariable(value = "id") Long id) {
        return estudanteService.excluirEstudantePeloId(id);

    }

    @GetMapping("/estudantes/nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Estudante> buscarEstudantePeloNome
            (@PathVariable(value = "nome") String nome) {
        return estudanteService.buscarEstudantePeloNome(nome);

    }

    @GetMapping("/estudantes/curso")
    @ResponseStatus(HttpStatus.OK)
    public List<Estudante> listarEstudantesPeloCurso(@RequestParam String nome_curso) {
        return estudanteService.listarEstudantesPeloCurso(nome_curso);
    }



    @GetMapping("/estudantes/nome")
    @ResponseStatus(HttpStatus.OK)
    public List<Estudante> listarEstudantesPeloComecoNome(@RequestParam String comeco_nome) {
        return estudanteService.listarEstudantesPeloComecoDoNome(comeco_nome);
    }

    @GetMapping("/estudantes/curso-nome")
    @ResponseStatus(HttpStatus.OK)
    public List<Estudante> listarEstudantesPeloComecoNomeECurso
            (@RequestParam String comeco_nome,
             @RequestParam String curso) {
        return estudanteService.listarEstudantesPeloComecoDoNomeECurso(comeco_nome, curso);
    }

    @GetMapping("/estudantes/endereco")
    @ResponseStatus(HttpStatus.OK)
    public List<Estudante> listarEstudantesPeloEndereco
            (@RequestParam String endereco
            ) {
        return estudanteService.listarEstudantesPeloEndereco(endereco);
    }

    @GetMapping("/estudantes/promo")
    @ResponseStatus(HttpStatus.OK)
    public List<Estudante> listarPrimeirosEstudantes
            (@RequestParam Long id
            ) {
        return estudanteService.listarPrimeirosEstudantes(id);
    }



}
