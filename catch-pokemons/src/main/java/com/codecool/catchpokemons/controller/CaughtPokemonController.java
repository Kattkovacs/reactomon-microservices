package com.codecool.catchpokemons.controller;

import com.codecool.catchpokemons.entity.CaughtPokemon;
import com.codecool.catchpokemons.service.CaughtPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
@CrossOrigin(origins = "http://localhost:3000")
public class CaughtPokemonController {

    @Autowired
    private CaughtPokemonService caughtPokemonService;

    @PostMapping("/catch/{name}")
    public void catchPokemon(@PathVariable("name") String name) {
        caughtPokemonService.saveCaughtPokemon(name);
    }

    @GetMapping("/all-caught-pokemons")
    public List<CaughtPokemon> getAllCaughtPokemons() {
        return caughtPokemonService.findAllPokemons();
    }

    @PostMapping("/remove/{name}")
    public void deleteCaughtPokemon(@PathVariable("name") String name) {
        caughtPokemonService.deleteCaughtPokemon(name);
    }
}
