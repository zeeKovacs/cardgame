package com.codecool;

import javax.xml.parsers.ParserConfigurationException;

public class AronTest {
    public static void main(String[] args) {
        XMLHandler handler = new XMLHandler("cards_example.xml");
        try {
            handler.load();
            Deck deck = handler.getDeck();
            GameData gameData = handler.getGameData();
            System.out.println(deck.getDeck().get(1).getName());
            System.out.println(gameData.getFieldDescription("Cruelty"));

        } catch (XMLLoadError e) {
            System.out.println(e);
        }
    }
}
