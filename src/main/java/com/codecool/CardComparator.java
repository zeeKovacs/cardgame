package com.codecool;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {

    private String key;

    CardComparator() {
    }

    CardComparator(String key) {
        this.key = key;
    }

    void setKey(String key) {
        this.key = key;
    }

    String getKey() {
        return this.key;
    }

    @Override
    public int compare(Card o1, Card o2) {
        Integer stat = o1.getStatByKey(key);
        Integer stat2 = o2.getStatByKey(key);
        return stat - stat2;
    }
}
