package com.AlicornLunaa.CellularSimulation.gameplay;

import com.AlicornLunaa.CellularSimulation.util.Color;
import com.AlicornLunaa.CellularSimulation.util.Vector3;

public class Cell {

    // Variables
    private String name;
    private String description;
    private float charge;
    private float mass;
    private Color color;
    private Vector3 velocity;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getCharge() {
        return charge;
    }

    public void setCharge(float charge) {
        this.charge = charge;
    }

    public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }

    public Color getColor() {
        return color;
    }

    public Vector3 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector3 velocity) {
        this.velocity = velocity;
    }

    // Constructor
    public Cell(String name, String description, float charge, float mass){
        this.name = name;
        this.description = description;
        this.charge = charge;
        this.mass = mass;

        this.color = new Color(255, 255, 255);
        this.velocity = new Vector3(0.f, 0.f);
    }

    // Static functions
    static public Cell getEmpty(){ return new Cell("Empty", "", 0.f, 0.f); }
    static public Cell getDebug(){ return new Cell("Debug", "Used to testing", 1.f, 1.f); }

}
