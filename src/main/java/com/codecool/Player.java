package com.codecool;


public class Player {

    String name;
    Deck hand;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHandSize() {
        return hand.getDeck().size();
    }

    public Card getNextCard() {
        return hand.next();
    }
}
