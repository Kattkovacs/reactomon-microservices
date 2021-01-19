package com.codecool.catchpokemons.repository;

import com.codecool.catchpokemons.entity.CaughtPokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaughtPokemonRepository extends JpaRepository<CaughtPokemon, Integer> {
}
