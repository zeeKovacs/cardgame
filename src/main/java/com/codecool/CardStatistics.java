package com.codecool;

import java.util.HashMap;
import java.util.Map;

public class CardStatistics {
    private Map<String, Float> data = new HashMap<>();

    public float getStatByKey(String key) {
        return data.get(key);
    }

    public void addStat(String key, float value) {
        data.put(key, value);
    }

    public String toString() {
        String str = "";
        for (String key : data.keySet()) {
            str += key + " " + Float.toString(data.get(key)) + "\n";
        }
        return str;
    }
}
