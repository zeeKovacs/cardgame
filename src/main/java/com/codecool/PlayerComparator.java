package com.codecool;

import java.util.Comparator;

public class PlayerComparator implements Comparator<Player> {

    CardComparator cp = new CardComparator();

    void setKey(String key) {
        cp.setKey(key);
    }

    @Override
    public int compare(Player o1, Player o2) {
        Card c1 = o1.getNextCard();
        Card c2 = o2.getNextCard();
        return cp.compare(c1, c2);
    }
}