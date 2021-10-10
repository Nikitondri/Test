package com.company.core;

import com.company.struct.heavenlyBody.Planet;
import com.company.struct.heavenlyBody.Satellite;
import com.company.struct.heavenlyBody.Star;
import com.company.struct.system.Galaxy;
import com.company.struct.system.StarSystem;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;

public class FillInfo {
    private static final String NAME = "NAME";
    private static final String STAR_SYSTEM = "STAR_SYSTEM";
    private static final String STAR = "STAR";
    private static final String PLANET = "PLANET";
    private static final String SATELLITE = "SATELLITE";
    private static final String WEIGHT = "WEIGHT";
    private static final String TEMPERATURE = "TEMPERATURE";
    private static final String SIZE = "SIZE";
    private static final String STAR_CLASS = "STAR_CLASS";
    private static final String COLOR = "COLOR";
    private static final String PLANET_CLASS = "PLANET_CLASS";
    private static final String SATELLITE_TYPE = "SATELLITE_TYPE";


    private static Satellite fillSatelliteInfo(Node satelliteNode){
        Satellite satellite = new Satellite();
        NodeList satelliteInfo = satelliteNode.getChildNodes();
        for(int i = 0; i < satelliteInfo.getLength(); i++){
            Node node = satelliteInfo.item(i);
            switch (node.getNodeName()) {
                case NAME -> satellite.setName(node.getTextContent());
                case WEIGHT -> satellite.setWeight(Double.parseDouble(node.getTextContent()));
                case TEMPERATURE -> satellite.setTemperature(Integer.parseInt(node.getTextContent()));
                case SIZE -> satellite.setSize(Double.parseDouble(node.getTextContent()));
                case SATELLITE_TYPE -> satellite.setSatelliteType(node.getTextContent());
            }
        }
        return satellite;
    }

    private static Planet fillPlanetInfo(Node planetNode){
        Planet planet = new Planet();
        HashSet<Satellite> satellites = new HashSet<>();
        NodeList planetInfo = planetNode.getChildNodes();
        for(int i = 0; i < planetInfo.getLength(); i++){
            Node node = planetInfo.item(i);
            switch (node.getNodeName()) {
                case NAME -> planet.setName(node.getTextContent());
                case WEIGHT -> planet.setWeight(Double.parseDouble(node.getTextContent()));
                case TEMPERATURE -> planet.setTemperature(Integer.parseInt(node.getTextContent()));
                case SIZE -> planet.setSize(Double.parseDouble(node.getTextContent()));
                case PLANET_CLASS -> planet.setPlanetClass(node.getTextContent());
                case SATELLITE -> satellites.add(fillSatelliteInfo(node));
            }
        }
        planet.setSatellites(satellites);
        return planet;
    }

    private static Star fillStarInfo(Node starNode){
        Star star = new Star();
        HashSet<Planet> planets = new HashSet<>();
        NodeList starInfo = starNode.getChildNodes();
        for(int i = 0; i < starInfo.getLength(); i++){
            Node node = starInfo.item(i);
            switch (node.getNodeName()) {
                case NAME -> star.setName(node.getTextContent());
                case WEIGHT -> star.setWeight(Double.parseDouble(node.getTextContent()));
                case TEMPERATURE -> star.setTemperature(Integer.parseInt(node.getTextContent()));
                case SIZE -> star.setSize(Double.parseDouble(node.getTextContent()));
                case STAR_CLASS -> star.setStarClass(node.getTextContent());
                case COLOR -> star.setColor(node.getTextContent());
                case PLANET -> planets.add(fillPlanetInfo(node));
            }
        }
        star.setPlanets(planets);
        return star;
    }

    private static StarSystem fillStarSystem(Node starSystemNode){
        StarSystem starSystem = new StarSystem();
        HashSet<Star> stars = new HashSet<>();
        NodeList starSystemInfo = starSystemNode.getChildNodes();
        for(int i = 0; i < starSystemInfo.getLength(); i++){
            Node node = starSystemInfo.item(i);
            if(node.getNodeName().equals(NAME)){
                starSystem.setName(node.getTextContent());
            }
            if(node.getNodeName().equals(STAR)){
                stars.add(fillStarInfo(node));
            }
        }
        starSystem.setStars(stars);
        return starSystem;
    }

    private static Galaxy fillGalaxy(Node galaxyNode){
        Galaxy galaxy = new Galaxy();
        HashSet<StarSystem> starSystems = new HashSet<>();
        NodeList starSystem = galaxyNode.getChildNodes();
        for(int i = 0; i < starSystem.getLength(); i++){
            if(starSystem.item(i).getNodeName().equals(STAR_SYSTEM)) {
                starSystems.add(fillStarSystem(starSystem.item(i)));
            }
        }
        galaxy.setStarSystems(starSystems);
        return galaxy;
    }

    public static Galaxy fillInfoGalaxy() throws ParserConfigurationException, IOException, SAXException {
        Document document = IOInfo.outputFile();
        Node galaxy = document.getDocumentElement();
        return fillGalaxy(galaxy);
    }
}
