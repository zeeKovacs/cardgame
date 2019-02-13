package com.codecool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StatisticsGenerator {
    public Card getAverageCard(Deck deck){
        List<Card> cards = deck.getDeck();
        Map<String, Integer> statSum = new HashMap<>();
        Set<String> keys = cards.get(0).getKeySet();
        for (String key : keys) {
            statSum.put(key, 0);
        }

        for (Card card : cards) {

        }
        return new Card();
    }
}
