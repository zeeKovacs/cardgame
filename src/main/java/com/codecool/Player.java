package com.codecool;



public abstract class Player {

    String name;
    protected Deck hand;

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


    public String selectStat() {
        return "";

    }

    public Card revealTopCard() {
        return hand.getDeck().get(0);
    }

    public Card getAndRemoveTopCard() {
        Card card = revealTopCard();
        hand.getDeck().remove(card);
        return card;
    }
}
