package com.linuxtips.reactivefeignstarwars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactivefeign.spring.config.EnableReactiveFeignClients;

@SpringBootApplication
@EnableReactiveFeignClients

public class ReactivefeignStarwarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactivefeignStarwarsApplication.class, args);
	}

}
