package com.bankaya.pokemon.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Ability {
    private String name;
    private String url;

    public Ability() {
    }

    public Ability(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
