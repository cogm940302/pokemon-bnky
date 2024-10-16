package com.bankaya.pokemon.request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetPokemonRequestTest {

    @Test
    public void gettersAndSetters() {
        GetPokemonRequest request = new GetPokemonRequest();
        request.setName("Pikachu");

        assertEquals("Pikachu", request.getName());
    }

    @Test
    public void toStringMethod() {
        GetPokemonRequest request = new GetPokemonRequest();
        request.setName("Pikachu");

        String expectedString = "GetPokemonRequest(name=Pikachu)";
        assertEquals(expectedString, request.toString());
    }


}