package com.bankaya.pokemon.exception;

import com.bankaya.pokemon.response.PokemonResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SoapExceptionHand {

    @ExceptionHandler(RuntimeException.class)
    public PokemonResponse handleSoapMessageException(RuntimeException ex) {
        System.err.println("Error en el pokemon: " + ex.getMessage());
        PokemonResponse error = new PokemonResponse();
        error.setMessage(ex.getMessage());
        error.setFound(false);
        return error;
    }


}
