package com.codecool;

import java.util.Collections;
import java.util.Random;
import java.util.Set;

public class AIPlayer extends Player {
    public AIPlayer(String name) {
        super(name);
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
