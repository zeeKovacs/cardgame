package com.codecool;

import javax.xml.parsers.ParserConfigurationException;

public class AronTest {
    public static void main(String[] args) {
        System.out.println("asfsdf");
        XMLHandler handler = new XMLHandler("cards_example.xml");
        try {
            handler.loadDeck();
        } catch (XMLLoadError e) {
            System.out.println(e);
        }
    }
}