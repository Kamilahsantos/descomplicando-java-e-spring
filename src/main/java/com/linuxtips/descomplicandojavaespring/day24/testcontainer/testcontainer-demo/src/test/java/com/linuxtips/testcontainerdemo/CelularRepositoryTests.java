package com.linuxtips.testcontainerdemo;


import com.linuxtips.testcontainerdemo.model.Celular;
import com.linuxtips.testcontainerdemo.repository.CelularRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(LocalStackConfig.class)
@ActiveProfiles("test")
class CelularRepositoryTests {

    @Autowired
    private CelularRepository celularRepository;

    @BeforeEach
    public void setUp() {
        celularRepository.deleteAll();
    }


    @DisplayName("deve salvar um celular na base com sucesso")
    @Test
    void deveSalvarCelularNaBaseComSucesso() {
        var celular = new Celular(null, 123.4, "nokia tijolo");

        celularRepository.save(celular);

        List<Celular> celularesSalvos = celularRepository.findAll();
        assertThat(celularesSalvos).hasSize(1);
        assertThat(celularesSalvos.get(0)).isEqualTo(celular);
    }

    @DisplayName("deve atualizar um celular na base com sucesso")
    @Test
    void deveAtualizarCelularNaBaseComSucesso() {
        var celular = new Celular(null, 1234.5, "samsung");

        celularRepository.save(celular);

        List<Celular> celularesBase = celularRepository.findAll();
        assertThat(celularesBase).hasSize(1);
        assertThat(celularesBase.get(0)).isEqualTo(celular);
        assertThat(celularesBase.get(0).getModelo()).isEqualTo("samsung");

        celular.setModelo("samsung s23");
        celularRepository.save(celular);

        celularesBase = celularRepository.findAll();
        assertThat(celularesBase).hasSize(1);
        assertThat(celularesBase.get(0)).isEqualTo(celular);
        assertThat(celularesBase.get(0).getModelo()).isEqualTo("samsung s23");
    }


    @DisplayName("deve excluir um celular na base com sucesso")
    @Test
    void deveExcluirCelularNaBaseComSucesso() {
        var celular = new Celular(null, 999.0, "iphone");

        celularRepository.save(celular);
        String id = celular.getId();
        assertThat(id).isNotNull();

        Optional<Celular> celularBase = celularRepository.findById(id);
        assertThat(celularBase.isPresent()).isTrue();
        assertThat(celularBase.get()).isEqualTo(celular);

        celularRepository.delete(celular);
        Optional<Celular> CelularNotRetrieved = celularRepository.findById(id);
        assertThat(CelularNotRetrieved.isPresent()).isFalse();

    }
}
