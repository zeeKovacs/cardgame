package com.codecool;

import java.util.Random;
import java.util.Set;

public class AIPlayer extends Player {
    private CardStatistics average;
    public AIPlayer(String name, CardStatistics average) {
        super(name);
        this.average = average;
    }

    @Override
    public String selectStat() {
        Card card = revealTopCard();
        Set<String> keySet = card.getKeySet();
        String[] keys = keySet.toArray(new String[keySet.size()]);
        Random random = new Random();
        int selection = random.nextInt(keys.length);
        return keys[selection];

    }
}
