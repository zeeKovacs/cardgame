package com.codecool;

import javax.xml.parsers.ParserConfigurationException;
import java.util.Comparator;

public class AronTest {
    public static void main(String[] args) {
        XMLHandler handler = new XMLHandler("src/data/cards_example.xml");
        try {
            handler.load();
            Deck deck = handler.getDeck();
            GameData gameData = handler.getGameData();
            System.out.println(deck.getDeck().get(1).getName());
            System.out.println(gameData.getFieldDescription("Reign_len"));

            Card c2 = deck.getDeck().get(1);
            Comparator<Card> comp = new CardComparator("Reign_len");
            deck.getDeck().sort(comp);
            System.out.println(deck);


        } catch (XMLLoadError e) {
            System.out.println(e);
        }
    }
}
