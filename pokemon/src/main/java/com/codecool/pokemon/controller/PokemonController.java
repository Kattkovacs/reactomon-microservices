package com.codecool.pokemon.controller;

import com.codecool.pokemon.model.Pokemon;
import com.codecool.pokemon.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
public class PokemonController {

    @Autowired
    PokemonRepository pokemonRepository;

    @GetMapping("/all")
    public List<Pokemon> getAllVideos(){
        return pokemonRepository.findAll();
    }

}
