package com.bankaya.pokemon.controller;

import com.bankaya.pokemon.exception.LogicException;
import com.bankaya.pokemon.request.PokemonAbilitiesRequest;
import com.bankaya.pokemon.response.PokemonAbilitiesResponse;
import com.bankaya.pokemon.service.PokemonService;
import com.bankaya.pokemon.response.GetPokemonResponse;
import com.bankaya.pokemon.request.GetPokemonRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PokemonEndpoint {
    private static final String NAMESPACE_URI = "http://poke.bankaya/pokemon";

    private final PokemonService pokemonService;

    @Autowired
    public PokemonEndpoint(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @Autowired
    private HttpServletRequest requesthttp;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonRequest")
    @ResponsePayload
    public GetPokemonResponse getPokemonInf(@RequestPayload GetPokemonRequest request) {
        String name = request.getName();
        String ipAddress = requesthttp.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = requesthttp.getRemoteAddr();
        }
        if(name == null || name.isEmpty()) {
            throw new LogicException("Pokemon Invalido");
        }
        return pokemonService.getPokemonInfo(name, ipAddress);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "pokemonAbilitiesRequest")
    @ResponsePayload
    public PokemonAbilitiesResponse getPokemonAbility(@RequestPayload PokemonAbilitiesRequest request) {
        String name = request.getName();

        if(name == null || name.isEmpty()) {
            throw new LogicException("Pokemon Invalido");
        }
        String ipAddress = requesthttp.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = requesthttp.getRemoteAddr();
        }
        return pokemonService.getPokemonAbility(name, ipAddress);
    }


}
