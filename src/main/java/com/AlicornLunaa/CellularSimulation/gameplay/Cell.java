package com.AlicornLunaa.CellularSimulation.gameplay;

import com.AlicornLunaa.CellularSimulation.rendering.Rectangle;
import com.AlicornLunaa.CellularSimulation.util.Color;
import org.joml.Vector2i;

public class Cell {

    // Static variables
    public static final int SIZE = 10;
    public enum CellType { EMPTY, ELECTRON, NEUTRON, PROTON, MOLECULE };

    // Variables
    protected String name;
    protected String description;
    protected Color color;
    protected float charge;
    protected float mass;
    protected Vector2i velocity;
    private Rectangle shape;
    private CellType type;

    private Color highlightedColor;
    private boolean highlighted;

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
        return isHighlighted() ? highlightedColor : color;
    }

    public void setColor(Color c){ color = c; }

    public Vector2i getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2i velocity) {
        this.velocity = velocity;
    }

    public Rectangle getShape(){ return shape; }

    public void highlight(boolean status){
        highlighted = status;
    }

    public boolean isHighlighted(){
        return highlighted;
    }

    public CellType getType(){ return type; }

    // Constructor
    public Cell(String name, String description, float charge, float mass, Color color, CellType type){
        this.name = name;
        this.description = description;
        this.charge = charge;
        this.mass = mass;
        this.color = color;
        this.type = type;

        velocity = new Vector2i(0, 0);

        shape = new Rectangle(0.f, 0.f, SIZE, SIZE);

        highlightedColor = new Color(127, 255, 0);
        highlighted = false;
    }

    // Static functions
    static public Cell getEmpty(){ return new Cell("Empty", "", 0.f, 0.f, new Color(50, 50, 50), CellType.EMPTY); }
    static public Cell getNeutron(){ return new Cell("Neutron", "Basic neutron", 0.f, 1.f, new Color(255, 255, 255), CellType.NEUTRON); }
    static public Cell getProton(){ return new Cell("Proton", "Basic proton", 1.f, 1.f, new Color(0, 255, 0), CellType.PROTON); }

}
