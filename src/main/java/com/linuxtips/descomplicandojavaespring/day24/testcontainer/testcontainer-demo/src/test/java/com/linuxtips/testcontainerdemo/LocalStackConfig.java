package com.linuxtips.testcontainerdemo;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.linuxtips.testcontainerdemo.model.Celular;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.localstack.LocalStackContainer;
import org.testcontainers.utility.DockerImageName;

import static org.testcontainers.containers.localstack.LocalStackContainer.Service.DYNAMODB;

@TestConfiguration
@TestPropertySource(properties = {
        "amazon.aws.accesskey=teste",
        "amazon.aws.secretkey=teste"
})
public class LocalStackConfig {

    @Autowired
    AmazonDynamoDB amazonDynamoDB;

    static LocalStackContainer localStack =
            new LocalStackContainer(DockerImageName.parse("localstack/localstack:1.0.4.1.nodejs18"))
                    .withServices(DYNAMODB)
                    .withNetworkAliases("localstack")
                    .withNetwork(Network.builder().createNetworkCmdModifier(cmd -> cmd.withName("test-net")).build());

    static {
        localStack.start();
        System.setProperty("amazon.dynamodb.endpoint", localStack.getEndpointOverride(DYNAMODB).toString());
    }

    @PostConstruct
    public void setupDynamo() {
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

        CreateTableRequest tableCelularRequest = dynamoDBMapper
                .generateCreateTableRequest(Celular.class);
        tableCelularRequest.setProvisionedThroughput(
                new ProvisionedThroughput(1L, 1L));
        amazonDynamoDB.createTable(tableCelularRequest);
    }
}
