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

public class XMLHandler {
    private String filepath;
    public XMLHandler(String filepath) {
        this.filepath = filepath;
    }


    public Deck loadDeck() throws XMLLoadError {
        DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
        Document doc = null;
        try {
            docBuilder = fac.newDocumentBuilder();
            doc = docBuilder.parse(new File(filepath));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new XMLLoadError();
        }
        NodeList docCardList = doc.getElementsByTagName("Card");

        for (int i = 0; i < docCardList.getLength(); i++ ){
            Element card = (Element)docCardList.item(i);
            System.out.println(card);
        }


        return new Deck("dfsd");
    }

}
