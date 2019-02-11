package com.codecool;

import java.util.HashMap;
import java.util.Map;

public class Card {

    int id;
    private String name;
    private Map<String, Integer> stats = new HashMap<>();

    public Card(int id, String name) {
       this.id = id;
       this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void addStat(String type, int stat) {
        stats.put(type, stat);
    }

    public Integer getStatByKey(String key) {
        return stats.get(key);
    }

    public Map<String, Integer> getAllStatistic() {
        return stats;
    }
}
