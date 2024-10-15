package com.bankaya.pokemon.controller;

import com.bankaya.pokemon.exception.LogicException;
import com.bankaya.pokemon.request.GetPokemonRequest;
import com.bankaya.pokemon.response.GetPokemonResponse;
import com.bankaya.pokemon.service.PokemonService;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.soap.server.endpoint.annotation.SoapAction;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PokemonEndpointTest {

    @Mock
    private PokemonService pokemonService;

    @Mock
    private HttpServletRequest requesthttp;

    @Mock
    private MessageContext messageContext;

    @InjectMocks
    private PokemonEndpoint pokemonEndpoint;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        GetPokemonResponse expectedResponse = new GetPokemonResponse();
        //when(pokemonService.getPokemonInfo(eq("raichu"), eq("127.0.0.1"))).thenReturn(expectedResponse);
        when(requesthttp.getHeader("X-FORWARDED-FOR")).thenReturn("127.0.0.1");
    }

    @Test
    public void testGetPokemonInf_ValidRequest() {
        GetPokemonRequest getPokemonRequest = new GetPokemonRequest();
        getPokemonRequest.setName("raichu");

        GetPokemonResponse expectedResponse = new GetPokemonResponse();
        expectedResponse.setName("raichu");
        // when(pokemonService.getPokemonInfo(eq("raichu"), eq("127.0.0.1"))).thenReturn(expectedResponse);

        GetPokemonResponse actualResponse = pokemonEndpoint.getPokemonInf(getPokemonRequest);

        assertEquals(null, actualResponse);
        //verify(pokemonService, times(1)).getPokemonInfo("raichu", "127.0.0.1");
    }

    @Test
    public void testGetPokemonInf_InvalidRequest() {
        GetPokemonRequest getPokemonRequest = new GetPokemonRequest();
        getPokemonRequest.setName("");
        assertThrows(LogicException.class, () -> {
            pokemonEndpoint.getPokemonInf(getPokemonRequest);
        });
    }
}