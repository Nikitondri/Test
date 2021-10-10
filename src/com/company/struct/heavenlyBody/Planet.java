package com.company.struct.heavenlyBody;

import java.util.HashSet;

public class Planet extends HeavenlyBody{
    private String planetClass;
    private HashSet<Satellite> satellites = new HashSet<>();

    public HashSet<Satellite> getSatellites() {
        return satellites;
    }

    public void setPlanetClass(String planetClass) {
        this.planetClass = planetClass;
    }

    public void setSatellites(HashSet<Satellite> satellites) {
        this.satellites = satellites;
    }

    public String getPlanetClass() {
        return planetClass;
    }
}
