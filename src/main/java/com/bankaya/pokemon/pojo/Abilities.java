package com.bankaya.pokemon.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Abilities {
    private Ability ability;
    private boolean is_hidden;
    private int slot;

    public Abilities() {
    }

    public Abilities(Ability ability, boolean is_hidden, int slot) {
        this.ability = ability;
        this.is_hidden = is_hidden;
        this.slot = slot;
    }


}
