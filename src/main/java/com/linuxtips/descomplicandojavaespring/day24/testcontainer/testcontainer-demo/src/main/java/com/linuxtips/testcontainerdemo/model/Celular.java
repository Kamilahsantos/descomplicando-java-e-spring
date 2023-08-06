package com.linuxtips.testcontainerdemo.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DynamoDBTable(tableName = "celulares")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Celular {

    private String id;

    private Double preco;

    private String modelo;

    @DynamoDBHashKey(attributeName = "Id")
    @DynamoDBAutoGeneratedKey
    public String getId() {
        return id;
    }

    @DynamoDBAttribute(attributeName = "preco")
    public Double getPreco() {
        return preco;
    }

    @DynamoDBAttribute(attributeName = "modelo")
    public String getModelo() {
        return modelo;
    }
}