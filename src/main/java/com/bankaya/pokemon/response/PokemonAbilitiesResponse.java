package com.bankaya.pokemon.response;

import com.bankaya.pokemon.pojo.Abilities;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "abilities"
})
@XmlRootElement(name = "pokemonAbilitiesResponse")
public class PokemonAbilitiesResponse extends PokemonResponse {
    private Abilities[] abilities;
}
