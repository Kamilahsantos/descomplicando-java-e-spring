package com.linuxtips.produtosapi.repository;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.linuxtips.produtosapi.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;


    public Produto salvar(Produto produto) {
        dynamoDBMapper.save(produto);
        return produto;
    }

    public Produto buscarProdutoPeloId(String produtoId) {
        return dynamoDBMapper.load(Produto.class, produtoId);
    }

    public String excluir(String produtoId) {
        Produto produto = dynamoDBMapper.load(Produto.class, produtoId);
        dynamoDBMapper.delete(produto);
        return "Produto excluido do cadastro";
    }

    public Produto atualizar(String produtoId, Produto produto) {
        dynamoDBMapper.save(new Produto
                        (produtoId, produto.getNome(),
                                produto.getPreco()),
                new DynamoDBSaveExpression()
                        .withExpectedEntry("produtoId",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(produtoId)
                                )));
        return produto;
    }
}
