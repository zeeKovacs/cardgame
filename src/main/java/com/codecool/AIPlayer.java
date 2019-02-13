package com.codecool;

import java.util.Scanner;
import java.util.Set;
import java.util.Timer;

public class AIPlayer extends Player {
    private CardStatistics statistics;
    private int delay = 3000;
    public AIPlayer(String name, CardStatistics statistics) {
        super(name);
        this.statistics = statistics;
    }

    @Override
    public String selectStat() {
        Card card = revealTopCard();
        Set<String> keySet = card.getKeySet();
        int size = keySet.size();
        String[] keys = keySet.toArray(new String[size]);

        float[] differencesFromAverage = new float[size];
        for (int i = 0; i < keys.length; i++) {
            float avg = statistics.getAverageByKey(keys[i]);
            float actual = (float) revealTopCard().getStatByKey(keys[i]);
            differencesFromAverage[i] = actual - avg;
        }

        int maxIndex = 0;
        for (int i = 0; i < size; i++) {
            if (differencesFromAverage[i] > differencesFromAverage[maxIndex]) {
                maxIndex = i;
            }
        }

        String selection = keys[maxIndex];
        Timer timer = new Timer();
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return selection;
    }
    /*
        public String selectStat() {
            Card card = revealTopCard();
            Set<String> keySet = card.getKeySet();
            String[] keys = keySet.toArray(new String[keySet.size()]);
            Random random = new Random();
            int selection = random.nextInt(keys.length);
            return keys[selection];

        }
     */
}
