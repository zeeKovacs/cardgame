package com.codecool;

import java.util.Random;

public class PlayerBuilder {
    /*
        Builds AI or Human players based on input given. Needs an UI instance for human player instantiation
        and a CardStatistics instance for ai instantiation.
     */
    private UI ui;
    private CardStatistics statistics;

    public PlayerBuilder(UI ui, CardStatistics statistics) {
        this.ui = ui;
        this.statistics = statistics;
    }

    public Player create(String name, String type) {
        Player player = null;

        switch(type) {
            case "human":
                player = new HumanPlayer(ui, name);
                break;
            case "easy":
                player = new AIPlayer(name, 0, statistics);
                break;
            case "medium":
                player = new AIPlayer(name, 50, statistics);
                break;
            case "hard":
                player = new AIPlayer(name, 100, statistics);


        }

        return player;
    }
}
