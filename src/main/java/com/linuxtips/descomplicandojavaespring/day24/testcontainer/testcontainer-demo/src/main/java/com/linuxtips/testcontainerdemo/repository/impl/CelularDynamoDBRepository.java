package com.linuxtips.testcontainerdemo.repository.impl;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.linuxtips.testcontainerdemo.model.Celular;
import com.linuxtips.testcontainerdemo.repository.CelularRepository;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

@Repository
public class CelularDynamoDBRepository extends DynamoDBRepository<Celular, String> implements CelularRepository {

    public CelularDynamoDBRepository(AmazonDynamoDB amazonDynamoDB, Environment env) {
        super(amazonDynamoDB, Celular.class, env);
    }

}
