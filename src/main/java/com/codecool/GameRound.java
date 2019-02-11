package com.codecool;

import java.util.List;

public class GameRound {

    private UI ui;
    private List<Player> players;
    private GameData gameData;

    public GameRound(UI ui, List<Player> players, GameData gameData) {
        this.ui = ui;
        this.players = players;
        this.gameData = gameData;
    }

    public boolean gameRuns() {
        return true;
    }

    public void run() {

    }
}
