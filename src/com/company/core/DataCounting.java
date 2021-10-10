package com.company.core;

import com.company.struct.heavenlyBody.Planet;
import com.company.struct.heavenlyBody.Satellite;
import com.company.struct.heavenlyBody.Star;
import com.company.struct.system.Galaxy;
import com.company.struct.system.StarSystem;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DataCounting {

    private static int countBodiesPlanet(Planet planet){
        return planet.getSatellites().size();
    }

    private static int countBodiesStar(Star star, int sum){
        for (Planet planet : star.getPlanets()) {
            sum++;
            sum += countBodiesPlanet(planet);
        }
        return sum;
    }

    private static int countBodiesStarSystem(StarSystem starSystem){
        int sum = 0;
        for(Star star: starSystem.getStars()){
            sum ++;
            sum = countBodiesStar(star, sum);
        }
        return sum;
    }

    private static void countHeavenlyBody(Galaxy galaxy){
        for (StarSystem starSystem : galaxy.getStarSystems()) {
            starSystem.setNumBodies(countBodiesStarSystem(starSystem));
        }
    }

    private static double countWeightSatellites(Planet planet, double sum){
        for (Satellite satellite : planet.getSatellites()) {
            sum += satellite.getWeight();
        }
        return sum;
    }

    private static double countWeightPlanet(Star star, double sum){
        for (Planet planet : star.getPlanets()) {
            sum = countWeightSatellites(planet, sum);
            sum += planet.getWeight();
        }
        return sum;
    }

    private static double countWeightStar(StarSystem starSystem){
        double sum = 0;
        for(Star star: starSystem.getStars()){
            sum = countWeightPlanet(star, sum);
            sum += star.getWeight();
        }
        return sum;
    }

    private static void countTotalWeight(Galaxy galaxy){
        for (StarSystem starSystem : galaxy.getStarSystems()) {
            starSystem.setTotalWeight(countWeightStar(starSystem));
        }
    }

    public static void countData(Galaxy galaxy) throws ParserConfigurationException, IOException, SAXException {
        countHeavenlyBody(galaxy);
        countTotalWeight(galaxy);
    }
}
