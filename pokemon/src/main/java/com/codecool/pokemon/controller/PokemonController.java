package com.codecool.pokemon.controller;

import com.codecool.pokemon.model.Pokemon;
import com.codecool.pokemon.repository.PokemonRepository;
import com.codecool.pokemon.service.PokemonDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
public class PokemonController {

    @Autowired
    PokemonRepository pokemonRepository;

    @Autowired
    PokemonDBService pokemonDBService;

    @GetMapping("/pokemons")
    public List<Pokemon> getAllPokemons(){
        return pokemonRepository.findAll();
    }

}
