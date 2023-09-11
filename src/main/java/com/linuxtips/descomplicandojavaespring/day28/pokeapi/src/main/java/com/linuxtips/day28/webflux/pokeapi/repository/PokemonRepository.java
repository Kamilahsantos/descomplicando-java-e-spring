package com.linuxtips.day28.webflux.pokeapi.repository;


import com.linuxtips.day28.webflux.pokeapi.model.Pokemon;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends ReactiveMongoRepository<Pokemon, String> {
}
