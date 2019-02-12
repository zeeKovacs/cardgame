package com.codecool;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class UI {

    private Scanner sc = new Scanner(System.in);
    private String input;
    private int intInput;

    public void printMainMenu() {
        System.out.println("Welcome to XYZ Card Game.\nPress 'S' to start or 'X' to exit!");
    }

    String getDeckType(List<String> deckTypes) {
        System.out.println("Please select a deck type.");
        listPrinter(deckTypes);
        intInput = getIntInput();
        while (intInput < 0 || intInput > deckTypes.size()) {
            intInput = getIntInput();
        }
        return deckTypes.get(intInput - 1);
    }

    String createPlayer(int serial) {
        System.out.println("Enter the " + serial + ". player's name.");
        return getInput();
    }

    int getPlayerNumber() {
        System.out.println("Enter the number of players. (1-4)");
        intInput = getIntInput();
        while (intInput < 0 || intInput > 4) {
            intInput = getIntInput();
        }
        return intInput;
    }

    public String statToCompare(Card card) {
        System.out.println("Choose which stat of the cards you want to compare.");
        System.out.println(card);
        input = getInput();
        while (!card.getKeySet().contains(input)) {
            System.out.println("Enter a valid stat.");
            input = getInput();
        }
        return input;
    }

    private int getIntInput() {
        while (!sc.hasNextInt()) {
            System.out.println("Enter a valid number.");
            input = sc.nextLine();
        }
        return sc.nextInt();
    }

    String getInput() {
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

    void startRound(List<Player> players) {
        for (Player p : players) {
            System.out.println(p.getName() + p.getHandSize());
        }
    }

    void endRound(Player winner) {
        System.out.println(winner.getName() + " has won the round.");
    }
}
