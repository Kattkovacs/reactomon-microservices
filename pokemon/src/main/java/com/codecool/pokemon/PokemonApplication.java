package com.codecool.pokemon;

import com.codecool.pokemon.model.Pokemon;
import com.codecool.pokemon.repository.PokemonRepository;
import com.codecool.pokemon.service.PokemonDBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@Slf4j
@EnableEurekaClient
public class PokemonApplication {

	@Autowired
	PokemonRepository pokemonRepository;

	@Autowired
	PokemonDBService pokemonDBService;

	public static void main(String[] args) {
		SpringApplication.run(PokemonApplication.class, args);
	}

//	@Bean
//	@LoadBalanced
//	public RestTemplate restTemplate(){return new RestTemplate();}

	@Bean
	@Profile("production")
	public CommandLineRunner init(){
		return args -> {
			pokemonDBService.importJSONData();
//            pokemonDBService.importPokemonData();
		};
	}
//
//	@PostConstruct
//	public void createPokemons(){
//		Pokemon pokemon1 = Pokemon.builder()
//				.name("PikachuTheOne")
//				.imageUrl("https://i.pinimg.com/originals/f5/1d/08/f51d08be05919290355ac004cdd5c2d6.png")
//				.build();
//		Pokemon pokemon2 = Pokemon.builder()
//				.name("EeveeTheOne")
//				.imageUrl("https://cdn.bulbagarden.net/upload/thumb/e/e2/133Eevee.png/250px-133Eevee.png")
//				.build();
//		Pokemon pokemon3 = Pokemon.builder()
//				.name("CharizardTheOne")
//				.imageUrl("https://i.pinimg.com/originals/69/4c/be/694cbef9df8d0af01d632d3e57e3db64.jpg")
//				.build();
//		Pokemon pokemon4 = Pokemon.builder()
//				.name("MewTheOne")
//				.imageUrl("https://cdn.bulbagarden.net/upload/thumb/b/b1/151Mew.png/1200px-151Mew.png")
//				.build();
//		List<Pokemon> pokemons = Arrays.asList(pokemon1, pokemon2, pokemon3, pokemon4);
//		pokemonRepository.saveAll(pokemons);
//		log.info("Pokemon examples created");
//	}
}
