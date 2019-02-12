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
        //winner.addCard(winner.getHand().next());
        for (Player player : players) {
            if (player.getHandSize() == 0) {
                declareWinner(players);
            }
        }

        ui.endRound(winner);
    }

    private void declareWinner(List<Player> players) {
        players.sort(pc);
        Player theWinner = players.get(0);
        ui.gameOver(theWinner);
    }


}
