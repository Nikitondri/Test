package com.company.struct.heavenlyBody;

import java.util.HashSet;

public class Star extends HeavenlyBody{
    private String starClass;
    private String color;
    private HashSet<Planet> planets = new HashSet<>();

    public String getStarClass() {
        return starClass;
    }

    public String getColor() {
        return color;
    }

    public HashSet<Planet> getPlanets() {
        return planets;
    }

    public void setStarClass(String starClass) {
        this.starClass = starClass;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPlanets(HashSet<Planet> planets) {
        this.planets = planets;
    }
}
