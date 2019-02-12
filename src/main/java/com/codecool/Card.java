package com.codecool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Card{

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

    public Set getKeySet() {
        return stats.keySet();
    }

    public void addStat(String type, int stat) {
        stats.put(type, stat);
    }

    public Integer getStatByKey(String key) {
        return stats.get(key);
    }

    @Override
    public String toString() {
        String toPrint = String.format("%-20s (%s)", name, id);
        for (String key : stats.keySet()) {
            toPrint += String.format("\n%-20s = %s" , key, stats.get(key));
        }
        return toPrint;
    }
}
