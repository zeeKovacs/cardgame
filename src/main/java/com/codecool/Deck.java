package com.codecool;

import java.util.Iterator;
import java.util.List;

public class Deck implements Iterator {

    String type;
    List<Card> deck;


    public Deck(String deckType) {

        type = deckType;
    }

    @Override
    public boolean hasNext() {
        return deck.size() > 0;
    }

    @Override
    public Card next() {
        Card nextCard = deck.get(deck.size()-1);
        deck.remove(deck.get(deck.size()-1));
        return nextCard;
    }
}