package com.codecool;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class XMLHandler {
    private String filepath;
    private Document document;
    public XMLHandler(String filepath) {
        this.filepath = filepath;
    }


    public Deck loadDeck() throws XMLLoadError {

        getDocument();
        GameData gameData = getGameData();

        return new Deck("dfsd");
    }

    private GameData getGameData() {
        NodeList docCardList = document.getElementsByTagName("Fields");
        GameData gameData = new GameData();
        for (int i = 0; i < docCardList.getLength(); i++ ){
            System.out.println("sdfsd");

            Element field = (Element)docCardList.item(i);
            String id = field.getAttribute("id");
            String description = field.getAttribute("description");

            System.out.println(id);
        }

        return gameData;
    }

    private void getDocument() throws XMLLoadError{
        DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
        try {
            docBuilder = fac.newDocumentBuilder();
            document = docBuilder.parse(new File(filepath));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new XMLLoadError();
        }
    }
}
