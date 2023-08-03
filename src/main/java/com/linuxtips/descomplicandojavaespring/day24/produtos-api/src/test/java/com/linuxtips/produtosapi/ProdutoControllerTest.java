package com.linuxtips.produtosapi;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.linuxtips.produtosapi.model.Produto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    @DisplayName("Deve buscar um produto pelo id com sucesso")
    @Test
    public void deveRetornarUmProdutoBuscandoPeloId() throws Exception {
        this.mockMvc.perform(get("/produtos/{id}", 123)).andDo(print()).andExpect(status().isOk());

    }

    @DisplayName("Deve criar um produto com sucesso")
    @Test
    public void deveCriarUmProduto() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/produtos")
                        .content(asJsonString(new Produto(UUID.randomUUID().toString(), "JAVA", 799.0)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

}
