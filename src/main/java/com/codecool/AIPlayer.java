package com.codecool;

import java.util.Random;
import java.util.Set;
import java.util.Timer;

public class AIPlayer extends Player {
    private CardStatistics statistics;
    private int delayTime = 3000;
    private int proficiency;
    private Random random = new Random();

    public AIPlayer(String name, int proficiency, CardStatistics statistics) {
        super(name);
        this.statistics = statistics;
        this.proficiency = proficiency;
    }

    @Override
    public String selectStat() {
        //delay();
        if (random.nextInt(100) < proficiency) {
            return selectBestStat();
        } else {
            return selectRandomStat();
        }
    }

    private String selectBestStat() {
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

        return selection;
    }

    private void delay() {
        Timer timer = new Timer();
        try {
            Thread.sleep(delayTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    private String selectRandomStat() {
        Card card = revealTopCard();
        Set<String> keySet = card.getKeySet();
        String[] keys = keySet.toArray(new String[keySet.size()]);
        int selection = random.nextInt(keys.length);
        return keys[selection];

    }

}
