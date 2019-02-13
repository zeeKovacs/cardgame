package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class GameRound {

    private UI ui;
    private List<Player> players;
    private List<Player> displayedPlayers = new ArrayList<>();
    private GameData gameData;
    private PlayerComparator pc = new PlayerComparator();
    private boolean isTheGameRunning = true;
    private Player gameWinner;
    private int roundCounter = 1;


    public Player getGameWinner() {
        return gameWinner;
    }

    public GameRound(UI ui, List<Player> players, GameData gameData) {
        this.ui = ui;
        this.players = players;
        for (Player player : players) {
            this.displayedPlayers.add(player);
        }
        this.gameData = gameData;
    }

    public boolean gameRuns() {
        return isTheGameRunning;
    }

    public void run() {

        Player startPlayer = players.get(players.size() - 1);
        ui.showRoundStartInfo(displayedPlayers, startPlayer, roundCounter);
        String selectedStat = startPlayer.selectStat();
        ui.showSelectedStat(startPlayer, gameData.getFieldDescription(selectedStat));
        pc.setKey(selectedStat);

        for (Player player : players) {
            ui.showPlayerCard(player);
        }
        players.sort(pc);
        Player winner = players.get(players.size() - 1);
        for (Player p : players) {
            winner.addCard(p.getAndRemoveTopCard());
        }
        ui.showRoundWinner(winner);
        List<Player> losers = new ArrayList<>();
        for (Player player : players) {
            if (player.getHandSize() == 0) {
                losers.add(player);
            }
        }

        for (Player player : losers) {
            players.remove(player);
            displayedPlayers.remove(player);
            ui.showLostPlayer(player);
        }

        if (players.size() == 1) {

            declareWinner(players.get(0));
        }
        roundCounter++;
    }

    private void declareWinner(Player player) {
        ui.ShowGameWinner(player);
        gameWinner = player;
        isTheGameRunning = false;
    }


}
