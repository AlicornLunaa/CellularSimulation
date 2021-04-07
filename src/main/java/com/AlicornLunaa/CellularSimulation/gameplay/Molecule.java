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

    private float electronSpacing = 10.f;
    private float animationTick = 0.f;

    // Functions
    private void getElectronPosition(Vector3f pos, int layer, int electronsInLayer, int electronNum){
        float ratio = (360.f / electronsInLayer);
        float cos = (float)Math.cos(Math.toRadians(electronNum * ratio + animationTick));
        float sin = (float)Math.sin(Math.toRadians(electronNum * ratio + animationTick));
        float space = electronSpacing * layer;

        pos.add(space * cos + space * sin, -space * sin + space * cos, 0.f);
    }

    private void createShapes(){
        // Creates the rectangles according to the counts given
        shapes.clear();

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
        int row = 0;
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
        Vector3f electronPos = new Vector3f(current);
        for(int i = protons + neutrons; i < protons + neutrons + electrons; i++) {
            // Get new electron information
            electronPos.set(current);
            int electronNum = i - (protons + protons) + 1; // The id of the electron the molecule is looping on right now

            // Rotate electrons around nucleus for each layer
            if(electronNum <= 2){
                // First layer
                getElectronPosition(electronPos, 1, Math.min(electrons, 2), electronNum);
            } else if(electronNum - 2 <= 8){
                // Second layer
                getElectronPosition(electronPos, 2, Math.min(electrons - 2, 8), electronNum - 2);
            } else if(electronNum - 10 <= 18){
                // Third layer
                getElectronPosition(electronPos, 3, Math.min(electrons - 10, 18), electronNum - 8);
            } else if(electronNum - 28 <= 32){
                // Fourth layer
                getElectronPosition(electronPos, 4, Math.min(electrons - 28, 32), electronNum - 18);
            } else if(electronNum - 60 <= 50){
                // Fifth layer
                getElectronPosition(electronPos, 5, Math.min(electrons - 60, 50), electronNum - 32);
            } else {
                // Sixth layer, purposely left unbound for gameplay fun
                getElectronPosition(electronPos, 6, electrons - 110, electronNum - 50);
            }

            shapes.get(i).setPosition(electronPos);
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
        animationTick += 0.4f;
    }

    public void addProton(int count){ protons = Math.max(1, protons + count); createShapes(); }
    public void addNeutron(int count){ neutrons = Math.max(1, neutrons + count); createShapes(); }
    public void addElectron(int count){ electrons = Math.max(1, electrons + count); createShapes(); }

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
