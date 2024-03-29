package com.linuxtips.produtosapi.model;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;



@DynamoDBTable(tableName = "produto")

public class Produto {

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String produtoId;

    @DynamoDBAttribute
    private String nome;


    @DynamoDBAttribute
    private Double preco;

    public Produto(String produtoId, String nome, Double preco) {
        this.produtoId = produtoId;
        this.nome = nome;
        this.preco = preco;
    }

    public Produto() {
    }

    public String getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(String produtoId) {
        this.produtoId = produtoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

}
