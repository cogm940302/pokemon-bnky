package com.bankaya.pokemon.request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokemonAbilitiesRequestTest {

    @Test
    public void gettersAndSetters() {
        PokemonAbilitiesRequest request = new PokemonAbilitiesRequest();
        request.setName("Charizard");

        assertEquals("Charizard", request.getName());
    }

    @Test
    public void toStringMethod() {
        PokemonAbilitiesRequest request = new PokemonAbilitiesRequest();
        request.setName("Charizard");

        String expectedString = "PokemonAbilitiesRequest(name=Charizard)";
        assertEquals(expectedString, request.toString());
    }

}