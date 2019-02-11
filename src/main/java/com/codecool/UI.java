package com.codecool;

import java.util.Scanner;

public class UI {

    public String getDeckType() {
        System.out.println("Please select a deck type.");
        String[] deckTypes = {"Dictators", "Goats", "Wardrobes"};
        arrPrinter(deckTypes);
        String input = getInput();
        return deckTypes[Integer.parseInt(input) - 1];
    }

    public void getCardStats(Card card) {
        System.out.println(card.getAllStatistic());
    }

    public String getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public void arrPrinter(String[] array) {
        for (int i = 1; i < array.length + 1; i++) {
            System.out.println(i + ". " + array[i - 1]);
        }
    }
}
