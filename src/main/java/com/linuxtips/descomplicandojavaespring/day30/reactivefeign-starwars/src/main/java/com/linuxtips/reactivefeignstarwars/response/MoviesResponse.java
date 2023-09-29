package com.linuxtips.reactivefeignstarwars.response;


import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class MoviesResponse {

    private List<String> characters;
    private String director;
    private String episode_id;
    private String opening_crawl;
    private String title;

}
