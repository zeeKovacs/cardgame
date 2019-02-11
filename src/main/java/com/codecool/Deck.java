package com.codecool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Deck implements Iterator<Card> {

    private String type;
    private List<Card> deck = new ArrayList<>();


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

    public void addCard(Card card) {
        deck.add(card);
    }
}
