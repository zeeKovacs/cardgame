package com.codecool;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Deck implements Iterator<Card> {

    String type;
    List<Card> deck;


    public Deck(String deckType) {
        type = deckType;
    }

    protected void shuffle() {
        Collections.shuffle(deck);
    }

    public List<Card> getDeck() {
        return deck;
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
