package com.codecool;

import java.util.Iterator;

public class CardHandler implements Iterator<Card> {

    Deck deck;

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Card next() {
        return null;
    }
}
