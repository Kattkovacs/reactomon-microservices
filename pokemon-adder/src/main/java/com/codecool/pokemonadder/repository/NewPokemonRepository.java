package com.codecool.pokemonadder.repository;

import com.codecool.pokemonadder.entity.NewPokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewPokemonRepository extends JpaRepository<NewPokemon, Long> {


}
