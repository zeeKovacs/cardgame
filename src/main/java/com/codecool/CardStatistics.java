package com.codecool;

import java.util.HashMap;
import java.util.Map;

public class CardStatistics {
    private Map<String, Float> average = new HashMap<>();
    private Map<String, Float> max = new HashMap<>();
    private Map<String, Float> min = new HashMap<>();


    public float getAverageByKey(String key) {
        return average.get(key);
    }

    public float getMaxByKey(String key) {
        return max.get(key);
    }

    public float getMinByKey(String key) {
        return min.get(key);
    }


    public void addAverageStat(String key, float value) {
        average.put(key, value);
    }

    public void addMaxStat(String key, float value) {
        max.put(key, value);
    }

    public void addMinStat(String key, float value) {
        min.put(key, value);
    }

    public String toString() {
        String str = "";
        for (String key : average.keySet()) {
            str += key + " " + Float.toString(average.get(key)) + "\n";
        }
        return str;
    }
}
