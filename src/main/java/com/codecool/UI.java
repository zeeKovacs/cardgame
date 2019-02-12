package com.codecool;

import java.util.*;

public class UI {

    private Scanner sc = new Scanner(System.in);
    private String input;
    private int intInput;

    public void printMainMenu() {
        clearTerminal();
        System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+\n" +
                           "|  Welcome to Cool Custom Card Game! |\n" +
                           "+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+\n" +
                           "\\Press 'S' to start or 'X' to exit!\\");
    }

    String getDeckType(List<String> deckTypes) {
        System.out.println("Please select a deck type!");
        listPrinter(deckTypes);
        intInput = getIntInput();
        while (intInput < 0 || intInput > deckTypes.size()) {
            System.out.println("Please enter a valid number.");
            intInput = getIntInput();
        }
        return deckTypes.get(intInput - 1);
    }

    String createPlayer(int serial) {
        System.out.println("Enter the " + serial + ". player's name!");
        return getInput();
    }

    int getPlayerNumber() {
        System.out.println("Enter the number of players! (1-4)");
        intInput = getIntInput();
        while (intInput < 0 || intInput > 4) {
            System.out.println("Please enter a valid number.");
            intInput = getIntInput();
        }
        return intInput;
    }

    public String statToCompare(Card card) {
        Set fields = card.getKeySet();
        List<String> fieldsList = new ArrayList<>();
        System.out.println(card + "\n\n===================================================" +
                                "\nChoose which stat of the cards you want to compare!");
        for (Object field : fields) {
            fieldsList.add((String) field);
        }
        listPrinter(fieldsList);
        intInput = getIntInput();
        while (intInput < 0 || intInput > fieldsList.size()) {
            System.out.println("Please enter a valid number.");
            intInput = getIntInput();
        }
        return fieldsList.get(intInput - 1);
    }

    private int getIntInput() {
        while (!sc.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            input = sc.nextLine();
        }
        intInput = sc.nextInt();
        sc.nextLine();
        return intInput;
    }

    String getInput() {
        input = sc.nextLine();
        while (input.equals("")) {
            System.out.println("Please enter a valid string.");
            input = sc.nextLine();
        }
        return input;
    }

    private void listPrinter(List list) {
        for (int i = 1; i < list.size() + 1; i++) {
            System.out.println(i + ". " + list.get(i - 1));
        }
    }

    void startRound(List<Player> players) {
        for (Player p : players) {
            System.out.println(p.getName() + " has " + p.getHandSize() + " cards in hand");
        }
    }

    void endRound(Player winner) {
        clearTerminal();
        System.out.println(winner.getName() + " has won the round. It's his/her turn now!");
    }

    public void gameOver(Player winner) {
        System.out.println("Game Over!\n" + "With " + winner.getHandSize() + " cards in hand\n" + winner.getName() + " has won the match!");
    }

    private void clearTerminal() {
        System.out.println("\033[H\033[2J");
    }
}
