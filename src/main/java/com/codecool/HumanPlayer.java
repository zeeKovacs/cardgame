package com.codecool;

public class HumanPlayer extends Player {
    private UI ui;
    public HumanPlayer(UI ui, String name) {
        super(name);
        this.ui = ui;
    }

    @Override
    public String selectStat() {

        return ui.statToCompare(revealTopCard());
    }
}
