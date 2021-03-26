package com.AlicornLunaa.CellularSimulation.gameplay;

import com.AlicornLunaa.CellularSimulation.util.Color;
import com.AlicornLunaa.CellularSimulation.util.Vector2;

public class Cell {

    // Variables
    String name;
    String description;
    float charge;
    float mass;
    Color color;
    Vector2 velocity;

    // Constructor
    public Cell(String name, String description, float charge, float mass){
        this.name = name;
        this.description = description;
        this.charge = charge;
        this.mass = mass;

        this.color = new Color(255, 255, 255);
        this.velocity = new Vector2(0.f, 0.f);
    }

    // Static functions
    static Cell getEmpty(){ return new Cell("Empty", "", 0.f, 0.f); }
    static Cell getDebug(){ return new Cell("Debug", "Used to testing", 1.f, 1.f); }

}
