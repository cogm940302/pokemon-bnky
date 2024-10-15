package com.bankaya.pokemon.response;

import com.bankaya.pokemon.pojo.Abilities;
import com.bankaya.pokemon.pojo.HeldItems;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "abilities",
        "baseExperience",
        "heldItems",
        "id",
        "locationAreaEncounters"
})
@XmlRootElement(name = "getPokemonResponse")
public class GetPokemonResponse extends PokemonResponse{

    private Abilities[] abilities;
    @JsonProperty("base_experience")
    @XmlElement(name = "base_experience")
    private Integer baseExperience;
    @JsonProperty("held_items")
    private HeldItems[] heldItems;
    private Integer id;
    @JsonProperty("location_area_encounters")
    private String locationAreaEncounters;



    public GetPokemonResponse() {
    }

}
