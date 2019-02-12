package com.codecool;

public class PlayerBuilder {
    /*
    Builds AI or HUuman players based on input given. Needs an UI instance for human player instantiation
     */
    private UI ui;

    public PlayerBuilder(UI ui) {
        this.ui = ui;
    }

    public Player create(String name, boolean human) {
        Player player;
        if (human) {
            player = new HumanPlayer(ui, name);
        } else {
            player = new AIPlayer(name);
        }
        return player;
    }
}
