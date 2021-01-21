package com.codecool.pokemon.service;

import com.codecool.pokemon.model.Pokemon;

import com.codecool.pokemon.model.Pokemons;
import com.codecool.pokemon.repository.PokemonRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
@Slf4j
public class PokemonDBService {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Value("${pokemons.url}")
    private String pokemonData;

    @Value("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/")
    private String imageUrl;

    public void importJSONData(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Pokemons> responseEntity = restTemplate
                .exchange(pokemonData, HttpMethod.GET, null, Pokemons.class);
        List<Pokemon> pokemons = responseEntity.getBody().getResults();

        for (Pokemon pokemon : pokemons) {
            try {
                pokemonRepository.save(pokemon);
                pokemon.setImageUrl(imageUrl + pokemon.getId() + ".svg");
                System.out.println(pokemon);
//                pokemon.setHeight(pokemonData+ "/" + pokemon.getId());
                pokemonRepository.save(pokemon);
            }
            catch (NullPointerException e) {
                log.info(e.toString());
            }
        }
    }
}
