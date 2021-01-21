package com.codecool.catchpokemons;

import com.codecool.catchpokemons.entity.CaughtPokemon;
import com.codecool.catchpokemons.repository.CaughtPokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class CatchPokemonsApplication {

	@Autowired
	private CaughtPokemonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CatchPokemonsApplication.class, args);
	}

	@PostConstruct
	public void init() {
		CaughtPokemon caughtPokemon = new CaughtPokemon();
		caughtPokemon.setName("Bimbocska");
		repository.save(caughtPokemon);
	}


	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant("/pokemons/**"))
				.build();
	}
}
