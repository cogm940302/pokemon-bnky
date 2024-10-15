package com.bankaya.pokemon.service;

import com.bankaya.pokemon.controller.PokemonEndpoint;
import com.bankaya.pokemon.exception.LogicException;
import com.bankaya.pokemon.repository.InfoRepository;
import com.bankaya.pokemon.response.GetPokemonResponse;
import com.bankaya.pokemon.response.PokemonAbilitiesResponse;
import com.bankaya.pokemon.response.PokemonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;


@Component
public class PokemonService {

    @Autowired
    private InfoRepository infoRepository;

    public GetPokemonResponse getPokemonInfo(String name, String ip) {
        long startTime = System.nanoTime();
        GetPokemonResponse pokemonInfo = consumeService(GetPokemonResponse.class, name);
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000;

        infoRepository.insertDataInfo(ip, "getPokemon", (int)durationInSeconds, name, pokemonInfo.toString().substring(0,Math.min(1000, pokemonInfo.toString().length())));
        return pokemonInfo;
    }

    public PokemonAbilitiesResponse getPokemonAbility(String name, String ip) {
        long startTime = System.nanoTime();
        PokemonAbilitiesResponse pokemonInfo = consumeService(PokemonAbilitiesResponse.class, name);
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000;
        infoRepository.insertDataInfo(ip, "getAbility", (int)durationInSeconds, name, pokemonInfo.toString().substring(0,Math.min(1000, pokemonInfo.toString().length())));
        return pokemonInfo;
    }

    private <T extends PokemonResponse> T consumeService(Class<T>  pr, String name) {
        WebClient webClient = WebClient.builder().baseUrl("https://pokeapi.co/api/v2/pokemon").build();
        try {
            T response = webClient.get()
                    .uri("/{name}", name)
                    .retrieve()
                    .bodyToMono(pr).block();
            response.setMessage("Pokemon encontrado");
            response.setFound(true);
            return response;
        } catch (WebClientResponseException e) {
            System.err.println("Error en el servicio: " + e.getMessage());
            throw new LogicException("Pokemon No Encontrado");
        }
    }

}

