package com.linuxtips.reactivefeignstarwars.controller;

import com.linuxtips.reactivefeignstarwars.client.FeignClient;
import com.linuxtips.reactivefeignstarwars.response.MoviesResponse;
import com.linuxtips.reactivefeignstarwars.response.PersonResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/linux-wars")
public class StarWarsController {

    FeignClient feignClient;


    @GetMapping("/people/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<PersonResponse> findPersonById(@PathVariable String id) {
        return feignClient.getPeopleById(id);
    }

    @GetMapping("/movies/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<MoviesResponse> findMovieById(@PathVariable String id) {
        return feignClient.getFilmById(id);
    }
}
