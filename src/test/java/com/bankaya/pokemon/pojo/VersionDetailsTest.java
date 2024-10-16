package com.bankaya.pokemon.pojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VersionDetailsTest {

    @Test
    public void testGettersAndSetters() {
        Version version = new Version();
        version.setName("version1");
        version.setUrl("https://localhost:8080");

        VersionDetails versionDetails = new VersionDetails();
        versionDetails.setRarity(5);
        versionDetails.setVersion(version);

        assertEquals(5, versionDetails.getRarity());
        assertEquals(version, versionDetails.getVersion());
    }

    @Test
    public void testToString() {
        Version version = new Version();
        version.setName("version1");
        version.setUrl("https://localhost:8080");

        VersionDetails versionDetails = new VersionDetails();
        versionDetails.setRarity(5);
        versionDetails.setVersion(version);

        String expectedString = "VersionDetails(rarity=5, version=Version(name=version1, url=https://localhost:8080))";
        assertEquals(expectedString, versionDetails.toString());
    }
}