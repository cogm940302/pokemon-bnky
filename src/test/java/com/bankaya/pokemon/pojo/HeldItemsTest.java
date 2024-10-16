package com.bankaya.pokemon.pojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeldItemsTest {

    @Test
    public void testGettersAndSetters() {
//        Item item = new Item("Potion", "https://pokeapi.co/api/v2/item/1/");
        Item item = new Item();
        item.setName("Pocion");
        item.setUrl("https://localhost:8080");

        VersionDetails[] versionDetails = new VersionDetails[1];
        versionDetails[0] = new VersionDetails();
        versionDetails[0].setVersion(new Version());
        versionDetails[0].setRarity(1);

        HeldItems heldItems = new HeldItems();
        heldItems.setItem(item);
        heldItems.setVersionDetails(versionDetails);

        assertEquals(item, heldItems.getItem());
        assertEquals(versionDetails, heldItems.getVersionDetails());
    }

    @Test
    public void testToString() {
        Item item = new Item();
        item.setName("Pocion");
        item.setUrl("https://localhost:8080");
        VersionDetails[] versionDetails = new VersionDetails[1];
        versionDetails[0] = new VersionDetails();
        versionDetails[0].setVersion(new Version());
        versionDetails[0].setRarity(1);

        HeldItems heldItems = new HeldItems();
        heldItems.setItem(item);
        heldItems.setVersionDetails(versionDetails);

        String expectedString = "HeldItems(item=Item(name=Pocion, url=https://localhost:8080), versionDetails=[VersionDetails(rarity=1, version=Version(name=null, url=null))])";
        assertEquals(expectedString, heldItems.toString());
    }
}