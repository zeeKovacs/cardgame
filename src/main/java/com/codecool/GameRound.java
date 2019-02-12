package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class GameRound {

    private UI ui;
    private List<Player> players;
    private GameData gameData;
    private PlayerComparator pc = new PlayerComparator();

    public GameRound(UI ui, List<Player> players, GameData gameData) {
        this.ui = ui;
        this.players = players;
        this.gameData = gameData;
    }

    public boolean gameRuns() {
        return true;
    }

    public void run() {
        ui.startRound(players);
        Player startPlayer = players.get(players.size() - 1);
        pc.setKey(startPlayer.selectStat());
        // pc.setKey(ui.statToCompare(players.get(players.size() - 1).revealTopCard()));

        for (Player player : players) {
            ui.showPlayerCard(player);
        }
        players.sort(pc);
        Player winner = players.get(players.size() - 1);
        //players.remove(winner);
        for (Player p : players) {
            winner.addCard(p.getAndRemoveTopCard());
        }
        ui.showRoundWinner(winner);
        //winner.addCard(winner.getHand().next());
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
        ui.gameOver(player);
        throw new ArrayIndexOutOfBoundsException();
    }


}
