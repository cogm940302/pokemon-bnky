package com.bankaya.pokemon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {

    @GetMapping("/pokemonInfo")
    public String pokemonInfo() {
        return "Más información en la siguiente liga: http://localhost:8080/ws/pokemon.wsdl";
    }
}
