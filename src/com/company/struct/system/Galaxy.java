package com.company.struct.system;

import java.util.HashSet;

public class Galaxy {
    private HashSet<StarSystem> starSystems = new HashSet<>();

    public void setStarSystems(HashSet<StarSystem> starSystems) {
        this.starSystems = starSystems;
    }

    public HashSet<StarSystem> getStarSystems() {
        return starSystems;
    }
}
