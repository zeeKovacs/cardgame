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
        pc.setKey(ui.statToCompare(players.get(0).getNextCard()));
        List<Player> ranks = new ArrayList<>();
        for (Player player : players) {
            ranks.add(player);
        }
        ranks.sort(pc);
        Player winner = ranks.get(ranks.size() - 1);
        ranks.remove(winner);
        for (Player p : ranks) {
            winner.addCard(p.getHand().next());
        }
        winner.addCard(winner.getHand().next());
        ui.endRound(winner);
    }
}
