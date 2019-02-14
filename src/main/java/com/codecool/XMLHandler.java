package com.codecool;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Set;

public class XMLHandler {
    private String filepath;
    private Document document;
    private Deck deck;
    private GameData gameData;


    public XMLHandler(String filepath) {
        this.filepath = filepath;
    }

    public XMLHandler() {

    }

    public GameData getGameData() {
        return gameData;
    }

    public Deck getDeck() {
        return deck;
    }

    public void load(String filepath) {
        this.filepath = filepath;
        load();
    }

    public void load() throws XMLLoadError {
        getDocument();
        loadGameData();
        Set<String> fields = gameData.getFieldIds();

        NodeList docCardList = document.getElementsByTagName("Card");
        deck = new Deck();
        int id = 0;
        for (int i = 0; i < docCardList.getLength(); i++) {
            Element docCard = (Element) docCardList.item(i);
            String name = docCard.getAttribute("name");
            if (name == "") {
                throw new XMLLoadError("Invalid name declaration at card no. " + Integer.toString(i + 1));
            }
            Card card = new Card(id, name);
            for (String field : fields) {
                Element docField = (Element) docCard.getElementsByTagName(field).item(0);
                String fieldName;
                int fieldValue;
                try {
                    fieldName = docField.getTagName();
                } catch (NullPointerException e) {
                    throw new XMLLoadError("Invalid or missing field name at card name: " + String.valueOf(name));
                }
                try {
                    fieldValue = Integer.parseInt(docField.getAttribute("val"));
                } catch (NumberFormatException e) {
                    throw new XMLLoadError("Invalid field value at card name: " + String.valueOf(name));
                }
                card.addStat(fieldName, fieldValue);
            }
            id++;
            deck.addCard(card);
        }
    }

    private GameData loadGameData() {
        Element docData = (Element) document.getElementsByTagName("Data").item(0);
        String name = docData.getAttribute("name");
        if (name == "") {
            throw new XMLLoadError("Missing card set name!");
        }
        String typeSingular = docData.getAttribute("type_singular");
        String typePlural = docData.getAttribute("type_plural");
        String gameDescription = docData.getTextContent();
        gameData = new GameData(name, gameDescription, typeSingular, typePlural);

        Element root = (Element) document.getElementsByTagName("Fields").item(0);
        NodeList docFieldList = root.getElementsByTagName("Field");

        for (int i = 0; i < docFieldList.getLength(); i++) {

            Element field = (Element) docFieldList.item(i);
            String id = field.getAttribute("id");
            String description = field.getAttribute("description");
            if (id == "") {
                throw new XMLLoadError("Invalid field id declaration in <Fields>");
            }
            if (description == "") {
                throw new XMLLoadError("Invalid field name declaration in <Fields>");

            }
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
        } catch (ParserConfigurationException | SAXException e) {
            throw new XMLLoadError();
        } catch (IOException e) {
            throw new XMLLoadError("Wrong filepath: " + filepath);
        }
    }
}
