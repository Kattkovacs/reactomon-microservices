package com.codecool.pokemon.service;

import com.codecool.pokemon.model.Pokemon;
import com.codecool.pokemon.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PokemonDBService {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Value("${pokemons.url}")
    private String pokemonData;

    public void importJSONData(){
        List<Pokemon> pokemons = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Pokemon> responseEntity = restTemplate.exchange(pokemonData, HttpMethod.GET, null, Pokemon.class);
        pokemons.add(PokemonMapper.listNewCocktails(responseEntity.getBody()));

        for (Pokemon pokemon : pokemons) {
            pokemonRepository.save(pokemon);
        }
    }
}
