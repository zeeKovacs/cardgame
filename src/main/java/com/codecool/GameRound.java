package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class GameRound {

    private UI ui;
    private List<Player> players;
    private GameData gameData;
    private PlayerComparator pc = new PlayerComparator();
    private boolean isTheGameRunning = true;
    private Player gameWinner;


    public Player getGameWinner() {
        return gameWinner;
    }

    public GameRound(UI ui, List<Player> players, GameData gameData) {
        this.ui = ui;
        this.players = players;
        this.gameData = gameData;
    }

    public boolean gameRuns() {
        return isTheGameRunning;
    }

    public void run() {
        ui.startRound(players);
        Player startPlayer = players.get(players.size() - 1);
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
            ui.showLostPlayer(player);
        }

        if (players.size() == 1) {

            declareWinner(players.get(0));
        }
    }

    private void declareWinner(Player player) {
        ui.ShowGameWinner(player);
        gameWinner = player;
        isTheGameRunning = false;
    }


}
