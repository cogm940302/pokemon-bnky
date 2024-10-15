package com.bankaya.pokemon.request;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "name"
})
@XmlRootElement(namespace="http://poke.bankaya/pokemon", name = "pokemonAbilitiesRequest")
public class PokemonAbilitiesRequest {

    @XmlElement(namespace="http://poke.bankaya/pokemon" , required = true)
    private String name;
}
