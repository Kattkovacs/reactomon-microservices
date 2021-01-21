package com.codecool.pokemonadder.controller;

import com.codecool.pokemonadder.entity.NewPokemon;
import com.codecool.pokemonadder.model.PokemonAbout;
import com.codecool.pokemonadder.repository.NewPokemonRepository;
import com.codecool.pokemonadder.service.NewPokemonDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class NewPokemonController {
    @Autowired
    private NewPokemonRepository newPokemonRepository;

    @Autowired
    private NewPokemonDBService newPokemonDBService;


    @PostMapping("/save-new-pokemon")
    public void createPokemon(@RequestBody NewPokemon newPokemon) {
        System.out.println(newPokemon);
        newPokemonDBService.createNewPokemon(newPokemon);
    }
}
