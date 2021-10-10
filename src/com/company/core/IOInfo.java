package com.company.core;

import com.company.struct.system.Galaxy;
import com.company.struct.system.StarSystem;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;


public class IOInfo {

    private static final String PATCH = "galaxy.xml";
    private static final String INPUT_PATH = "galaxy_result.xml";

    public static Document outputFile() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        return documentBuilder.parse(new File(PATCH));
    }

    private static void fillOutputElements(Document document, Galaxy galaxy){
        Element root = document.createElement("GALAXY");
        document.appendChild(root);
        for(StarSystem starSystem: galaxy.getStarSystems()){
            Element starSystemItem = document.createElement("STAR_SYSTEM");
            root.appendChild(starSystemItem);
            Element nameItem = document.createElement("NAME");
            nameItem.setTextContent(starSystem.getName());
            starSystemItem.appendChild(nameItem);
            Element NumBodiesItem = document.createElement("NUMBER_BODIES");
            NumBodiesItem.setTextContent(Integer.toString(starSystem.getNumBodies()));
            starSystemItem.appendChild(NumBodiesItem);
            Element totalWeightItem = document.createElement("TOTAL_WEIGHT");
            totalWeightItem.setTextContent(Double.toString(starSystem.getTotalWeight()));
            starSystemItem.appendChild(totalWeightItem);
        }
    }

    public static void inputFile(Galaxy galaxy) throws ParserConfigurationException, TransformerException {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.newDocument();
        fillOutputElements(document, galaxy);
        File file = new File(INPUT_PATH);
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(document), new StreamResult(file));
    }
}
