package com.codecool.pokemonadder.controller;

import com.codecool.pokemonadder.entity.NewPokemon;
import com.codecool.pokemonadder.model.PokemonAbout;
import com.codecool.pokemonadder.repository.NewPokemonRepository;
import com.codecool.pokemonadder.service.NewPokemonDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/pokemons")
@RestController
public class NewPokemonController {
    @Autowired
    private NewPokemonRepository newPokemonRepository;

    @Autowired
    private NewPokemonDBService newPokemonDBService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/save-new-pokemon")
    public void createPokemon(@RequestBody PokemonAbout pokemonAbout) {
        System.out.println(pokemonAbout);
        newPokemonDBService.createNewPokemon(pokemonAbout);
    }
}
