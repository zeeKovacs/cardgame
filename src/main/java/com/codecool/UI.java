package com.codecool;

import java.util.Map;
import java.util.Scanner;

public class UI {
    String input;

    String getDeckType() {
        System.out.println("Please select a deck type.");
        String[] deckTypes = {"Dictators", "Goats", "Wardrobes"};
        arrPrinter(deckTypes);
        input = getInput();
        // input is within the range of 0 and deckTypes.length
        return deckTypes[Integer.parseInt(input) - 1];
    }

    public String statToCompare(Card card) {
        Map<String, Integer> stats = card.getAllStatistic();
        mapPrinter(stats);
        input = getInput();
        // input is in the keySet() of the map
        return input;
    }

    private String getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private void arrPrinter(String[] array) {
        for (int i = 1; i < array.length + 1; i++) {
            System.out.println(i + ". " + array[i - 1]);
        }
    }

    private void mapPrinter(Map<String, Integer> map) {
        for (String key : map.keySet()) {
            System.out.println(key + map.get(key));
        }
    }
}
