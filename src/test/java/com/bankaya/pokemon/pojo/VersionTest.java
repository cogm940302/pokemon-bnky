package com.bankaya.pokemon.pojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VersionTest {

    @Test
    public void testGettersAndSetters() {
        Version version = new Version();
        version.setName("version1");
        version.setUrl("https://localhost:8080");

        assertEquals("version1", version.getName());
        assertEquals("https://localhost:8080", version.getUrl());
    }

    @Test
    public void testToString() {
        Version version = new Version();
        version.setName("version1");
        version.setUrl("https://localhost:8080");

        String expectedString = "Version(name=version1, url=https://localhost:8080)";
        assertEquals(expectedString, version.toString());
    }
}