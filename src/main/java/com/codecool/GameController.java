package com.codecool;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameController {

    private Deck deckOnTable;
    private UI ui = new UI();
    private GameData gameData;
    
    public void mainMenu() {
        ui.printMainMenu();
        String userInput = ui.getInput().toLowerCase();
        switch (userInput) {
            case "s":
                List<Player> players = initialize();
                handCards(players);
                startGame(players);
                break;
            case "x":
                System.exit(1);
            default:
                break;
        }
    }

    private List<Player> initialize() {
        boolean successfulDeckLoad = false;
        XMLHandler reader = new XMLHandler();
        while (!successfulDeckLoad) {
            try {
                String deckType = ui.getDeckType(getDeckNames());
                reader.load("src/data/" + deckType + ".xml");
                successfulDeckLoad = true;
            } catch (XMLLoadError e) {
                ui.printMessage("\nCard Deck loading error!");
                ui.printMessage(e.getMessage());
                ui.printMessage("Fix your deck file or choose another one.\n");
            }
        }
        List<Player> players = new ArrayList<>();
        deckOnTable = reader.getDeck();
        deckOnTable.shuffle();
        gameData = reader.getGameData();
        ui.showGameInstructions(gameData);
        StatisticsGenerator statisticsGenerator = new StatisticsGenerator();
        CardStatistics average = statisticsGenerator.getAverageCard(deckOnTable);
        PlayerCreator playerCreator = new PlayerCreator(ui, average);

        int playerNumber = ui.getPlayerNumber();
        for (int i = 0; i < playerNumber; i++) {
            String name = ui.askPlayerName(i + 1);
            String player = ui.askPlayerType(name);
            players.add(playerCreator.create(name, player));

        }
        Collections.shuffle(players);
        return players;
    }

    private void handCards(List<Player> players) {
        while (deckOnTable.hasNext()) {
            for (Player player : players) {
                if (deckOnTable.hasNext()) {
                    player.addCard(deckOnTable.next());
                }
            }
        }
    }

    private void startGame(List<Player> players) {
        GameRound gameRound = new GameRound(ui, players, gameData);
        while (gameRound.gameRuns()) {
            gameRound.run();
        }
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
