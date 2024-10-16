package com.bankaya.pokemon.pojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AbilityTest {

    @Test
    public void testGettersAndSetters() {
        Ability ability = new Ability();
        ability.setName("rayo");
        ability.setUrl("https://localhost:8080");

        assertEquals("rayo", ability.getName());
        assertEquals("https://localhost:8080", ability.getUrl());
    }

    @Test
    public void testToString() {
        Ability ability = new Ability("rayo", "https://localhost:8080");
        String expectedString = "Ability(name=rayo, url=https://localhost:8080)";
        assertEquals(expectedString, ability.toString());
    }
}