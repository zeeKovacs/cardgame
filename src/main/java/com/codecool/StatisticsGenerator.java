package com.codecool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StatisticsGenerator {
    public CardStatistics getAverageCard(Deck deck) {
        List<Card> cards = deck.getDeck();
        Map<String, Integer> statSum = new HashMap<>();
        Map<String, Integer> statMax = new HashMap<>();
        Set<String> keys = cards.get(0).getKeySet();
        for (String key : keys) {
            statSum.put(key, 0);
            statMax.put(key, 0);
        }
        // Get Sum
        for (Card card : cards) {
            for (String key : keys) {
                int currentCardFieldVal = card.getStatByKey(key);
                statSum.put(key, statSum.get(key) + currentCardFieldVal);
            }
        }
        // Get max

        for (Card card : cards) {
            for (String key : keys) {
                int currentCardFieldVal = card.getStatByKey(key);
                if (currentCardFieldVal > statMax.get(key)) {
                    statMax.put(key, currentCardFieldVal);
                }
            }
        }

        CardStatistics statistics = new CardStatistics();
        int deckSize = deck.getSize();

        for (String key : keys) {
            statistics.addAverageStat(key, statSum.get(key) / (float) deckSize);
            statistics.addMaxStat(key, statMax.get(key));
        }
        return statistics;
    }
}
