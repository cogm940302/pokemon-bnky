package com.bankaya.pokemon.pojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AbilitiesTest {

    @Test
    public void testGettersAndSetters() {
        Ability ability = new Ability("rayo", "https://localhost:8080");
        Abilities abilities = new Abilities();
        abilities.setAbility(ability);
        abilities.set_hidden(true);
        abilities.setSlot(1);

        assertEquals(ability, abilities.getAbility());
        assertTrue(abilities.is_hidden());
        assertEquals(1, abilities.getSlot());
    }

    @Test
    public void testToString() {
        Ability ability = new Ability("rayo", "https://localhost:8080");
        Abilities abilities = new Abilities(ability, true, 1);

        String expectedString = "Abilities(ability=Ability(name=rayo, url=https://localhost:8080), is_hidden=true, slot=1)";
        assertEquals(expectedString, abilities.toString());
    }
}