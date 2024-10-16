package com.bankaya.pokemon.request;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "name"
})
@XmlRootElement(namespace="http://poke.bankaya/pokemon", name = "getPokemonRequest")
public class GetPokemonRequest {

    @XmlElement(namespace="http://poke.bankaya/pokemon" , required = true)
    private String name;

}
