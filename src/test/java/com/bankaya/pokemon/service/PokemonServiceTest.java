package com.bankaya.pokemon.service;

import com.bankaya.pokemon.exception.LogicException;
import com.bankaya.pokemon.repository.InfoRepository;
import com.bankaya.pokemon.response.GetPokemonResponse;
import com.bankaya.pokemon.response.PokemonAbilitiesResponse;
import com.bankaya.pokemon.response.PokemonResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.reactive.function.client.WebClient;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PokemonServiceTest {

    @MockBean
    private InfoRepository infoRepository;

    @MockBean
    private WebClient.Builder webClientBuilder;

    @MockBean
    private WebClient webClient;

    @MockBean
    private WebClient.RequestHeadersUriSpec requestHeadersUriSpec;

    @MockBean
    private WebClient.ResponseSpec responseSpec;

    @MockBean
    private PokemonService pokemonService;

    @BeforeEach
    public void setUp() {
        when(webClientBuilder.baseUrl(any(String.class))).thenReturn(webClientBuilder);
        when(webClientBuilder.build()).thenReturn(webClient);
        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri(any(String.class), any(String.class))).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.retrieve()).thenReturn(responseSpec);
    }

    @Test
    public void testGetPokemonInfo_Success() {
        GetPokemonResponse expectedResponse = new GetPokemonResponse();
        expectedResponse.setMessage("Pokemon encontrado");
        expectedResponse.setFound(true);

        when(  pokemonService.getPokemonInfo(  anyString(), anyString()  )  ).thenReturn(expectedResponse);

        GetPokemonResponse actualResponse = pokemonService.getPokemonInfo("pikachu", "127.0.0.1");

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testGetPokemonAbility_Success() {
        PokemonAbilitiesResponse expectedResponse = new PokemonAbilitiesResponse();
        expectedResponse.setMessage("Pokemon encontrado");
        expectedResponse.setFound(true);

        when(  pokemonService.getPokemonAbility(  anyString(), anyString()  )  ).thenReturn(expectedResponse);
        PokemonAbilitiesResponse actualResponse = pokemonService.getPokemonAbility("pikachu", "127.0.0.1");

        assertEquals(expectedResponse, actualResponse);
    }
//
    @Test
    public void testGetPokemonInfo_NotFound() {
        when(pokemonService.getPokemonInfo (anyString(),anyString()) ).thenThrow(LogicException.class);

        assertThrows(LogicException.class, () -> {
            pokemonService.getPokemonInfo("unknown", "127.0.0.1");
        });
    }
//
    @Test
    public void testGetPokemonAbility_NotFound() {
        when(pokemonService.getPokemonAbility (anyString(),anyString()) ).thenThrow(LogicException.class);

        assertThrows(LogicException.class, () -> {
            pokemonService.getPokemonAbility("unknown", "127.0.0.1");
        });
    }
}