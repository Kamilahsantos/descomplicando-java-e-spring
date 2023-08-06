package com.linuxtips.testcontainerdemo.repository.impl;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.linuxtips.testcontainerdemo.repository.GenericRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
public abstract class DynamoDBRepository<T, ID> implements GenericRepository<T, ID> {

    protected final AmazonDynamoDB amazonDynamoDB;

    private final Class<T> instanceClass;

    private final Environment environment;

    public DynamoDBRepository(AmazonDynamoDB amazonDynamoDB, Class<T> instanceClass, Environment environment) {
        this.amazonDynamoDB = amazonDynamoDB;
        this.instanceClass = instanceClass;
        this.environment = environment;
    }

    @Override
    public List<T> findAll() {
        DynamoDBMapper mapper = new DynamoDBMapper(amazonDynamoDB);
        return mapper.scan(instanceClass, new DynamoDBScanExpression());
    }

    @Override
    public Optional<T> findById(ID id) {
        DynamoDBMapper mapper = new DynamoDBMapper(amazonDynamoDB);

        T entity = mapper.load(instanceClass, id);

        if (entity != null) {
            return Optional.of(entity);
        }
        return Optional.empty();
    }

    @Override
    public T save(T entity) {
        DynamoDBMapper mapper = new DynamoDBMapper(amazonDynamoDB);
        mapper.save(entity);
        return entity;
    }

    @Override
    public void delete(T entity) {
        DynamoDBMapper mapper = new DynamoDBMapper(amazonDynamoDB);
        mapper.delete(entity);
    }


    public void deleteAll() {
        List<String> activeProfiles = Arrays.stream(environment.getActiveProfiles()).toList();
        if (activeProfiles.contains("test")) {
            List<T> entities = findAll();
            if (!CollectionUtils.isEmpty(entities)) {
                log.info("Limpando tabela");
                entities.forEach(this::delete);
            }
        }
    }
}
