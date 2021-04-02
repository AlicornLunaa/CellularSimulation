package com.AlicornLunaa.CellularSimulation.gameplay;

import com.AlicornLunaa.CellularSimulation.rendering.Rectangle;
import com.AlicornLunaa.CellularSimulation.util.Color;
import org.joml.Vector2f;

public class Cell {

    // Variables
    private String name;
    private String description;
    private float charge;
    private float mass;
    private Color color;
    private Vector2f velocity;
    private Rectangle shape;

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

    public Vector2f getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2f velocity) {
        this.velocity = velocity;
    }

    public Rectangle getShape(){ return shape; }

    // Constructor
    public Cell(String name, String description, float charge, float mass){
        this.name = name;
        this.description = description;
        this.charge = charge;
        this.mass = mass;

        this.color = new Color(255, 255, 255);
        this.velocity = new Vector2f(0.f, 0.f);

        this.shape = new Rectangle(0.f, 0.f, 10.f, 10.f);
    }

    // Static functions
    static public Cell getEmpty(){ return new Cell("Empty", "", 0.f, 0.f); }
    static public Cell getDebug(){ return new Cell("Debug", "Used to testing", 1.f, 1.f); }

}
