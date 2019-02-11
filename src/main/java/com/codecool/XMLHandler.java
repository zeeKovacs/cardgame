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
import java.util.Set;

public class XMLHandler {
    private String filepath;
    private Document document;

    public XMLHandler(String filepath) {
        this.filepath = filepath;
    }


    public Deck loadDeck() throws XMLLoadError {

        getDocument();
        GameData gameData = getGameData();
        Set<String> fields = gameData.getFieldIds();
        Deck deck = new Deck("Test deck");

        NodeList docCardList = document.getElementsByTagName("Card");
        for (int i = 0; i < docCardList.getLength(); i++) {
            Element docCard = (Element) docCardList.item(i);
            int id = Integer.parseInt(docCard.getAttribute("id"));
            String name = docCard.getAttribute("name");
            System.out.println(name);
            Card card = new Card(id, name);
            for (String field : fields) {

                Element docField = (Element) docCard.getElementsByTagName(field).item(0);
                String fieldName = docField.getTagName();
                int fieldValue = Integer.parseInt( docField.getAttribute("val"));
                card.addStat(fieldName, fieldValue);
            }

        }

        return new Deck("dfsd");
    }

    private GameData getGameData() {
        Element root = (Element) document.getElementsByTagName("Fields").item(0);
        NodeList docFieldList = root.getElementsByTagName("Field");
        GameData gameData = new GameData();


        for (int i = 0; i < docFieldList.getLength(); i++) {

            Element field = (Element) docFieldList.item(i);
            String id = field.getAttribute("id");
            String description = field.getAttribute("description");
            gameData.addField(id, description);

        }

        return gameData;
    }

    private void getDocument() throws XMLLoadError {
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
