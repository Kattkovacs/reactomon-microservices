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

    public void createNewPokemon(NewPokemon newPokemon){
        NewPokemon pokemon = new NewPokemon();
        pokemon.setName(newPokemon.getName());
        pokemon.setUrl(newPokemon.getUrl());
        pokemon.setImageUrl(newPokemon.getImageUrl());
//        pokemon.setHeight((newPokemon.getHeight()));
        newPokemonRepository.save(pokemon);
    }
}
