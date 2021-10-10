package com.company.struct.system;

import com.company.struct.heavenlyBody.Star;

import java.util.HashSet;

public class StarSystem {
    private String name;
    private int numBodies;
    private double totalWeight;
    private HashSet<Star> stars = new HashSet<>();


    public int getNumBodies() {
        return numBodies;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setNumBodies(int numBodies) {
        this.numBodies = numBodies;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public String getName() {
        return name;
    }

    public HashSet<Star> getStars() {
        return stars;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStars(HashSet<Star> stars) {
        this.stars = stars;
    }
}
