package com.AlicornLunaa.CellularSimulation.gameplay;

import com.AlicornLunaa.CellularSimulation.rendering.*;
import com.AlicornLunaa.CellularSimulation.util.*;
import org.joml.Vector2f;
import org.joml.Vector3f;

import java.util.ArrayList;

public class Molecule extends Cell {

    // Variables
    private int protons;
    private int neutrons;
    private int electrons;
    private ArrayList<Rectangle> shapes = new ArrayList<Rectangle>();

    // Functions
    private void createShapes(){
        // Creates the rectangles according to the counts given
        for(int i = 0; i < protons + neutrons + electrons; i++) {
            shapes.add(new Rectangle(0, 0, Cell.SIZE, Cell.SIZE));

            if(i < protons){
                shapes.get(i).color = new Color(0, 255, 0);
            } else if(i < protons + neutrons){
                shapes.get(i).color = new Color(250, 250, 250);
            } else if(i < protons + neutrons + electrons){
                shapes.get(i).color = new Color(255, 0, 0);
            }
        }
    }

    private void drawShapes(Shader shader){
        // Updates the positions of all the shapes
        Vector3f current = new Vector3f(getShape().getPosition());
        float spacer = (Cell.SIZE + World.CELL_SPACING);

        // Loop through all protons
        for(int i = 0; i < protons; i++) {
            shapes.get(i).setPosition(current);
            shapes.get(i).draw(shader);
        }

        // Loop through all neutrons
        for(int i = protons; i < protons + neutrons; i++) {
            shapes.get(i).setPosition(current);
            shapes.get(i).draw(shader);
        }

        // Loop through all electrons
        for(int i = protons + neutrons; i < protons + neutrons + electrons; i++) {
            shapes.get(i).setPosition(current);
            shapes.get(i).draw(shader);
        }
    }

    public String toString(){
        return String.format("{ Name: '%s', Desc: '%s', Charge: %f, Mass: %f }", name, description, charge, mass);
    }

    @Override
    public void draw(Shader shader){
        // Draw self and then each proton, neutron, and electron
        super.draw(shader);
        drawShapes(shader);
    }

    public void addCell(){

    }

    // Constructor
    public Molecule(int protonCount, int neutronCount, int electronCount){
        super("Molecule", "A collections of atoms", 0, 0, new Color(200, 200, 200), CellType.MOLECULE);

        protons = protonCount;
        neutrons = neutronCount;
        electrons = electronCount;

        ElementInfo info = ElementUtil.getInfo(protonCount, neutronCount, electronCount);
        name = info.name;
        description = info.description;
        charge = info.charge;
        mass = info.mass;
        color = info.color;

        createShapes();
    }

}
