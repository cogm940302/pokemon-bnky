package com.bankaya.pokemon.pojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {

    @Test
    public void testGettersAndSetters() {
        Item item = new Item();
        item.setName("Pocion");
        item.setUrl("https://localhost:8080");

        assertEquals("Pocion", item.getName());
        assertEquals("https://localhost:8080", item.getUrl());
    }

    @Test
    public void testToString() {
        Item item = new Item();
        item.setName("Pocion");
        item.setUrl("https://localhost:8080");

        String expectedString = "Item(name=Pocion, url=https://localhost:8080)";
        assertEquals(expectedString, item.toString());
    }
}