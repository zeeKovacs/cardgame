package com.codecool;



public class Player {

    String name;
    Deck hand;

    public Player(String name) {
        this.name = name;
        hand = new Deck();
    }

    public String getName() {
        return name;
    }

    public void addCard(Card card) {
        hand.addCard(card);
    }

    public int getHandSize() {
        return hand.getDeck().size();
    }

    public Card getNextCard() {
        return hand.getDeck().get(0);
    }

    public Deck getHand() {
        return hand;
    }
}
