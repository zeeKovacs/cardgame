package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    Deck deckOnTable;
    XMLHandler reader;
    List<Player> players = new ArrayList<>();
    UI ui = new UI();



    public void mainMenu() {
        ui.printMainMenu();
        String userInput = ui.getInput().toLowerCase();
        switch (userInput) {
            case "s":
                startGame();
            case "x":
                System.exit(1);
        }
    }

    public void startGame() {
        ui.printStartGameMenu();
        int playerNumber = ui.getPlayerNumber();
        for (int i=0; i < playerNumber; i++) {
            addPlayer(i+1);
        }
    }

    public void addPlayer(int serial) {
        Player player = ui.createPlayer(serial);
        players.add(player);
    }
}
