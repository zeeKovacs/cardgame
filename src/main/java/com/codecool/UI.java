package com.codecool;

import java.util.List;
import java.util.Scanner;

public class UI {
    private String input;

    public void printMainMenu() {
        System.out.println("Welcome to XYZ Card Game.\nPress 'S' to start or 'X' to exit!");

    }

    String getDeckType(List<String> deckTypes) {
        System.out.println("Please select a deck type.");
        listPrinter(deckTypes);
        input = getInput();
        // input is within the range of 0 and deckTypes.length
        return deckTypes.get(Integer.parseInt(input) - 1);
    }

    String createPlayer(int serial) {
        System.out.println("Enter the " + serial + ". player's name.");
        return getInput();
    }

    int getPlayerNumber() {
        System.out.println("Enter the number of players. (1-4)");
        // if playerNum is between 1-4
        return Integer.parseInt(getInput());
    }

    public String statToCompare(Card card) {
        System.out.println("Choose which stat of the cards you want to compare.");
        System.out.println(card);
        input = getInput();
        // input is in the keySet() of the map
        return input;
    }

    String getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private void arrPrinter(String[] array) {
        for (int i = 1; i < array.length + 1; i++) {
            System.out.println(i + ". " + array[i - 1]);
        }
    }

    private void listPrinter(List list) {
        for (int i = 1; i < list.size() + 1; i++) {
            System.out.println(i + ". " + list.get(i - 1));
        }
    }
}
