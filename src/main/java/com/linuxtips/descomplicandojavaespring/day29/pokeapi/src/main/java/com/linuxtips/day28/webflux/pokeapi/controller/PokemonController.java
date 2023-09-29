package com.linuxtips.day28.webflux.pokeapi.controller;


import com.linuxtips.day28.webflux.pokeapi.model.Pokemon;
import com.linuxtips.day28.webflux.pokeapi.service.PokemonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    private final PokemonService pokemonService;


    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Pokemon> criarPokemon(@RequestBody Pokemon pokemon) {
        return pokemonService.salvarPokemon(pokemon);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<Pokemon> listarPokemons() {
        return pokemonService.listarPokemon();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Pokemon> buscarPokemonPeloId(@PathVariable String id) {
        return pokemonService.buscarPokemonPeloId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ResponseEntity<Pokemon>> atualizarPokemon(@PathVariable(value = "id") String id,
                                                          @RequestBody Pokemon pokemon) {
        return pokemonService.atualizarPokemon(pokemon, id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> atualizarPokemonPeloId(@PathVariable String id) {
        return pokemonService.excluirPokemon(id);
    }

}
