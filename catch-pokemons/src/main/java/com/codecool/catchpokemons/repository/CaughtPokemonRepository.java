package com.codecool.catchpokemons.repository;

import com.codecool.catchpokemons.entity.CaughtPokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CaughtPokemonRepository extends JpaRepository<CaughtPokemon, Integer> {
    @Transactional
    void deleteByName(String name);

    CaughtPokemon findByName(String name);
}
