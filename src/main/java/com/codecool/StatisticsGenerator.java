package com.codecool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StatisticsGenerator {
    public CardStatistics getAverageCard(Deck deck) {
        List<Card> cards = deck.getDeck();
        Map<String, Integer> statSum = new HashMap<>();
        Set<String> keys = cards.get(0).getKeySet();
        for (String key : keys) {
            statSum.put(key, 0);
        }

        for (Card card : cards) {
            for (String key : keys) {
                int currentCardVal = card.getStatByKey(key);
                statSum.put(key, statSum.get(key) + currentCardVal);
            }
        }
        CardStatistics average = new CardStatistics();
        int deckSize = deck.getSize();

        for (String key : keys) {
            average.addStat(key, statSum.get(key) / (float) deckSize);
        }
        return new CardStatistics();
    }
}
