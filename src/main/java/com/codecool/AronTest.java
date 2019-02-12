package com.codecool;

import javax.xml.parsers.ParserConfigurationException;
import java.util.Comparator;

public class AronTest {
    public static void main(String[] args) {
        XMLHandler handler = new XMLHandler("src/data/master_dictator.xml");
        try {
            handler.load();
            Deck deck = handler.getDeck();
            GameData gameData = handler.getGameData();
            System.out.println(gameData);
            System.out.println(deck.getDeck().get(1).getName());


            Card c2 = deck.getDeck().get(1);
            Comparator<Card> comp = new CardComparator("cruelty");
            deck.getDeck().sort(comp);
            System.out.println(deck);


        } catch (XMLLoadError e) {
            System.out.println(e);
        }
    }
}
