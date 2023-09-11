package com.linuxtips.day28.webflux.pokeapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "pokemons")
public record Pokemon(@Id String id,
                      String nome, String tipo, List<String> evolucoes) {
}