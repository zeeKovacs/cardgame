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

    public Deck getDeck() {
        return deckOnTable;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public GameData getGameData() {
        return gameData;
    }

    public void mainMenu() {
        ui.printMainMenu();
        String userInput = ui.getInput().toLowerCase();
        switch (userInput) {
            case "s":
                initialize();
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
        gameData = reader.getGameData();
        int playerNumber = ui.getPlayerNumber();
        for (int i = 0; i < playerNumber; i++) {
            addPlayer(i + 1);
        }
    }

    private void startGame() {

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
