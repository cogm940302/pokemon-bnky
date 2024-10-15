package com.bankaya.pokemon.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class VersionDetails {
    private int rarity;
    private Version version;
}
