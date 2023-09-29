package com.linuxtips.reactivefeignstarwars.client;


import com.linuxtips.reactivefeignstarwars.response.MoviesResponse;
import com.linuxtips.reactivefeignstarwars.response.PersonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(url = "https://swapi.dev/api/", name = "star-wars")
public interface FeignClient {

    @GetMapping("/people/{id}")
    Mono<PersonResponse> getPeopleById(@RequestParam(value = "id") String id);

    @GetMapping("/films/{id}")
    Mono<MoviesResponse> getFilmById(@RequestParam(value = "id") String id);

}
