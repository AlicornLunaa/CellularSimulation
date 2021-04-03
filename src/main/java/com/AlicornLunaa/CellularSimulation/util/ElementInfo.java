package com.AlicornLunaa.CellularSimulation.util;

public class ElementInfo {

    public String name;
    public String description;
    public float charge;
    public float mass;
    public Color color;

    public ElementInfo(String name, String description, float charge, float mass, Color color){
        this.name = name;
        this.description = description;
        this.charge = charge;
        this.mass = mass;
        this.color = color;
    }

}
