package com.codecool.pokemonadder.service;

import com.codecool.pokemonadder.entity.NewPokemon;
import com.codecool.pokemonadder.model.PokemonAbout;
import com.codecool.pokemonadder.repository.NewPokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewPokemonDBService {
    @Autowired
    private NewPokemonRepository newPokemonRepository;

    public void createNewPokemon(PokemonAbout pokemonAbout){
        NewPokemon pokemon = new NewPokemon();
        pokemon.setName(pokemonAbout.getName());
        pokemon.setImageUrl(pokemonAbout.getImageUrl());
        newPokemonRepository.save(pokemon);
    }
}
