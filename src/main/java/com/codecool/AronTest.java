package com.codecool;

public class AronTest {
    public static void main(String[] args) {
        XMLHandler handler = new XMLHandler("src/data/master_dictator.xml");
        try {
            handler.load();
            Deck deck = handler.getDeck();
            GameData gameData = handler.getGameData();
            StatisticsGenerator statisticsGenerator = new StatisticsGenerator();
            CardStatistics cardStatistics = statisticsGenerator.getAverageCard(deck);
            PlayerCreator playerCreator = new PlayerCreator(new UI(), cardStatistics);
            Player player = playerCreator.create("a", "hard");
            player.addDeck(deck);
            player.selectStat();
            System.out.println("anyád");


        } catch (XMLLoadError e) {
            System.out.println(e);
        }
    }
}
