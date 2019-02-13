package com.codecool;

import javax.xml.parsers.ParserConfigurationException;
import java.util.Comparator;

public class AronTest {
    public static void main(String[] args) {
        XMLHandler handler = new XMLHandler("src/data/master_dictator.xml");
        try {
            handler.load();
            Deck deck = handler.getDeck();
            GameData gameData = handler.getGameData();
            StatisticsGenerator statisticsGenerator = new StatisticsGenerator();
            CardStatistics cardStatistics = statisticsGenerator.getAverageCard(deck);
            PlayerBuilder playerBuilder = new PlayerBuilder(new UI(), cardStatistics);
            Player player = playerBuilder.create("a", "hard");
            player.addDeck(deck);
            player.selectStat();
            System.out.println("anyád");


        } catch (XMLLoadError e) {
            System.out.println(e);
        }
    }
}
