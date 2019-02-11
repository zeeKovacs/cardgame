package com.codecool;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GameController {

    private Deck deckOnTable;
    private XMLHandler reader;
    private List<Player> players = new ArrayList<>();
    private UI ui = new UI();
    private GameData gameData;


    public void mainMenu() {
        ui.printMainMenu();
        String userInput = ui.getInput().toLowerCase();
        switch (userInput) {
            case "s":
                initialize();
                handCards();
                startGame();
            case "x":
                System.exit(1);
        }
    }

    private void initialize() {
        String deckType = ui.getDeckType(getDeckNames());
        reader = new XMLHandler("src/data/" + deckType + ".xml");
        reader.load();
        deckOnTable = reader.getDeck();
        deckOnTable.shuffle();
        gameData = reader.getGameData();
        int playerNumber = ui.getPlayerNumber();
        for (int i = 0; i < playerNumber; i++) {
            addPlayer(i + 1);
        }
    }

    private void handCards() {
        while (deckOnTable.hasNext()) {
            for (Player player : players) {
                player.addCard(deckOnTable.next());
            }
        }
    }

    private void startGame() {
        GameRound gameRound = new GameRound(ui, players, gameData);
        while (gameRound.gameRuns()) {
            gameRound.run();
        }
    }

    private void addPlayer(int serial) {
        Player player = new Player(ui.createPlayer(serial));
        players.add(player);
    }

    private List<String> getDeckNames() {
        File folder = new File("src/data/");
        File[] listOfFiles = folder.listFiles();
        List<String> fileNames = new ArrayList<>();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                fileNames.add(file.getName().replace(".xml", ""));
            }
        }
        return fileNames;
    }
}
