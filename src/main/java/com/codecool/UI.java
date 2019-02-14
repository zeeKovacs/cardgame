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

    String askPlayerName(int playerNumber) {
        System.out.println("Enter the " + playerNumber + ". player's name!");
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

    void showRoundStartInfo(List<Player> players, Player startPlayer, int roundNum) {
        System.out.println("-------------------------- Round " + Integer.toString(roundNum) + " -----------------------");
        for (Player p : players) {
            System.out.println(p.getName() + " has " + p.getHandSize() + " cards in hand");
        }
        System.out.println("It's " + startPlayer.getName() + "'s selection turn.");
    }

    public void showPlayerCard(Player player) {

        System.out.println(player.getName() + " has");
        System.out.println(player.revealTopCard() + "\n");
    }

    void showRoundWinner(Player winner) {
        clearTerminal();gameData
        System.out.println(winner.getName() + " has won the round.");
    }

    public void ShowGameWinner(Player winner) {
        System.out.println("Game Over!\n" + "With " + winner.getHandSize() + " cards in hand\n" + winner.getName() + " has won the match!");
    }

    private void clearTerminal() {
        System.out.println("\033[H\033[2J");
    }

    public void showGameInstructions(GameData gameData) {
        System.out.println(gameData);
    }

    public void showLostPlayer(Player player) {
        System.out.println(player.getName() + " has lost the game.\n");
    }

    public String askPlayerType(String name) {
        System.out.println("Set control for '" + name + "'\n1. Human\n2. Easy AI\n3. Medium AI\n4. Hard AI");
        String player = null;
        while (player == null) {
            int selection = getIntInput();

            if (selection == 1) {
                player = "human";
            } else if (selection == 2) {
                player = "easy";
            } else if (selection == 3) {
                player = "medium";
            } else if (selection == 4) {
                player = "hard";
            } else {
                System.out.println("Invalid number given!");
            }
        }
        return player;
    }

    public void showSelectedStat(Player player, String statName) {
        System.out.println((player.getName() + " selected " + statName + "\n"));
    }

    public void printMessage(String msg) {
        System.out.println(msg);
    }
}
