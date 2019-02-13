package com.codecool;

import java.util.HashMap;
import java.util.Map;

public class Statistics {
    private Map<String, Float> data = new HashMap<>();

    public float getStatByKey(String key) {
        return data.get(key);
    }

    public void addStat(String key, float value) {
        data.put(key, value);
    }

}
