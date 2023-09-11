package com.linuxtips.day28.webflux.pokeapi.service;

import com.linuxtips.day28.webflux.pokeapi.model.Pokemon;
import com.linuxtips.day28.webflux.pokeapi.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PokemonService {


    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Autowired
    private PokemonRepository pokemonRepository;

    public Mono<Pokemon> salvarPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public Flux<Pokemon> listarPokemon() {
        return pokemonRepository.findAll();

    }

    public Mono<Pokemon> buscarPokemonPeloId(String id) {
        return pokemonRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)));

    }

    public Mono<ResponseEntity<Pokemon>> atualizarPokemon(Pokemon pokemon, String id) {
        return pokemonRepository.findById(id)
                .flatMap(pokemonBase -> pokemonRepository.save(new Pokemon(id, pokemon.nome(), pokemon.tipo(), pokemon.evolucoes()))).map(pokemonAtualizado -> new ResponseEntity<>(pokemonAtualizado, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public Mono<Void> excluirPokemon(String id) {
        return buscarPokemonPeloId(id)
                .flatMap(pokemonRepository::delete);
    }

}
