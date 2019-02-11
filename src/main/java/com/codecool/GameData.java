package com.codecool;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GameData {
    private Map<String, String> fields = new HashMap<>();

    public void addField(String id, String description) {
        fields.put(id, description);
    }

    public Set<String> getFieldIds() {
        return fields.keySet();
    }

    public String getFieldDescription(String id) {
        return fields.get(id);
    }
}
