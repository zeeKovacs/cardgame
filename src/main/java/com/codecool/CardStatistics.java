package com.codecool;

import java.util.HashMap;
import java.util.Map;

public class CardStatistics {
    private Map<String, Float> average = new HashMap<>();
    private Map<String, Integer> max = new HashMap<>();


    public float getAverageByKey(String key) {
        return average.get(key);
    }

    public int getMaxByKey(String key) {
        return max.get(key);
    }



    public void addAverageStat(String key, float value) {
        average.put(key, value);
    }

    public void addMaxStat(String key, int value) {
        max.put(key, value);
    }



    public String toString() {
        String str = "";
        for (String key : average.keySet()) {
            str += key + " " + Float.toString(average.get(key)) + "\n";
        }
        return str;
    }
}
