package com.codecool;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GameData {
    private Map<String, String> fields = new HashMap<>();
    private String name;
    private String typeSingular;
    private String typePlural;

    public GameData(String name, String typeSingular, String typePlural) {
        this.typePlural = typePlural;
        this.typeSingular = typeSingular;
        this.name = name;

    }

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
