package com.codecool.catchpokemons.controller;

import com.codecool.catchpokemons.entity.CaughtPokemon;
import com.codecool.catchpokemons.service.CaughtPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokemons")
public class CaughtPokemonController {

    @Autowired
    private CaughtPokemonService caughtPokemonService;

    @PostMapping("/catch/${name}")
    public CaughtPokemon addVideo(@PathVariable("name") String name) {
        return caughtPokemonService.saveCaughtPokemon(name);
    }
}
