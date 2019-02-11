package com.codecool;


import java.util.HashMap;
import java.util.Map;

public class GameData {
    private Map<String, String> fields = new HashMap<>();

    public void addField(String id, String description) {
        fields.put(id, description);
    }

}
