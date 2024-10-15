package com.bankaya.pokemon.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PokemonController.class)
public class PokemonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPokemonInfo() throws Exception {
        mockMvc.perform(get("/pokemonInfo"))
                .andExpect(status().isOk())
                .andExpect(content().string("Más información en la siguiente liga: http://localhost:8080/ws/pokemon.wsdl"));
    }
}