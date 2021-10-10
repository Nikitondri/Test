package com.company.struct.heavenlyBody;

public abstract class HeavenlyBody {
    private String name;
    private double weight;
    private int temperature;
    private double size;

    public double getWeight() {
        return weight;
    }

    public int getTemperature() {
        return temperature;
    }

    public double getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setSize(double size) {
        this.size = size;
    }
}