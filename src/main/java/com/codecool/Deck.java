package com.codecool;

import java.util.Iterator;
import java.util.List;

public class Deck implements Iterator {

    String type;
    List<Card> deck;
    XMLHandler reader;

    public Deck(String filePath, String deckType) {
        reader = new XMLHandler(filePath);
        deck = reader.loadDeck();
        type = deckType;
    }

    @Override
    public boolean hasNext() {
        return deck.size() > 0;
    }

    @Override
    public Card next() {
        Card nextCard = deck.get(deck.size()-1);
        deck.remove(nextCard);
        return nextCard;
    }
}
