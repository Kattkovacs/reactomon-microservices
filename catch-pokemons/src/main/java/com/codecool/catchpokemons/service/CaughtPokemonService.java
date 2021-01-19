package com.codecool.catchpokemons.service;

import com.codecool.catchpokemons.entity.CaughtPokemon;
import com.codecool.catchpokemons.repository.CaughtPokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaughtPokemonService {

    @Autowired
    private CaughtPokemonRepository repository;

    public CaughtPokemon saveCaughtPokemon(String name) {
        CaughtPokemon caughtPokemon = new CaughtPokemon();
        caughtPokemon.setName(name);
        return repository.save(caughtPokemon);
    }
}
