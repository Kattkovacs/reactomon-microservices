package com.codecool.pokemon.repository;


import com.codecool.pokemon.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    @Override
    Optional<Pokemon> findById(Long aLong);

    @Override
    List<Pokemon> findAll();
}
