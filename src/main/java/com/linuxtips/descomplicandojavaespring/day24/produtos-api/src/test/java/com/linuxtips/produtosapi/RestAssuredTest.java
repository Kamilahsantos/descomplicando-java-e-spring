package com.linuxtips.produtosapi;


import com.linuxtips.produtosapi.model.Produto;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.fail;

public class RestAssuredTest {

    static {
        RestAssured.baseURI = "http://localhost:8080/";
    }


    private Response criaProduto(Produto produto) throws Exception {
        RequestSpecification request
                = given()
                .contentType("application/json")
                .body(produto);

        return request.post("/produtos");
    }


    private ResponseSpecification responseSpec(int responseStatus) {
        return new ResponseSpecBuilder()
                .expectStatusCode(responseStatus)
                .build();
    }

    @Test
    @DisplayName("Deve criar um produto com sucesso")
    public void deveCriarUmProdutoComSucesso() {
        try {
            criaProduto(new Produto("123", "java", 108.0))
                    .then()
                    .assertThat().spec(responseSpec(201))
                    .and()
                    .assertThat().body("nome", equalTo("java"));
        } catch (Exception e) {
            fail("Não foi possível cadastrar um produto", e);
        }

    }


    @Test
    @DisplayName("Deve buscar um produto pelo id com sucesso ")
    public void deveBuscarUmProdutoPeloIdComSucesso() {
        try {
            criaProduto(new Produto("123", "java", 108.0));

            given()
                    .when()
                    .basePath("/produtos")
                    .get("/123")
                    .then()
                    .assertThat().spec(responseSpec(200))
                    .and()
                    .assertThat().body("preco", equalTo(108.0F));
        } catch (Exception e) {
            fail("Erro ao buscar um produto pelo id", e);
        }
    }


    @Test
    @DisplayName("Deve excluir um produto pelo id com sucesso ")
    public void deveExcluirUmProdutoPeloIdComSucesso() {
        try {
            criaProduto(new Produto("456", "spring", 799.0));

            given()
                    .when()
                    .basePath("/produtos")
                    .delete("/456")
                    .then()
                    .assertThat().spec(responseSpec(204));

        } catch (Exception e) {
            fail("Erro ao excluir um produto pelo id", e);
        }


    }

    @Test
    @DisplayName("Deve retornar exception ao tentar excluir produto que não existe")
    public void deveRetornarErroAoTentarExcluirProduto() {
        try {

            given()
                    .when()
                    .basePath("/produtos")
                    .delete("/999")
                    .then()
                    .assertThat().spec(responseSpec(500));

        } catch (Exception e) {
            fail("Erro ao excluir um produto pelo id", e);
        }
    }

}
