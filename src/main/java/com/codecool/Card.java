package com.codecool;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Card {

    int id;
    private String name;
    private Map<String, Integer> stats = new HashMap<>();

    public Card(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Card() {
    }

    public String getName() {
        return name;
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
        String toPrint = "+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+\n" +
                String.format("| %-25s (%2d) |", name, id) +
                "\no~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~o";
        for (String key : stats.keySet()) {
            toPrint += String.format("\n| %-25s %4d |", key, stats.get(key));
        }
        toPrint += "\n+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+";
        return toPrint;
    }
}
