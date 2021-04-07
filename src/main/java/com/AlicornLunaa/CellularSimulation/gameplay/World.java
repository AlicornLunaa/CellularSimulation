package com.AlicornLunaa.CellularSimulation.gameplay;

import com.AlicornLunaa.CellularSimulation.physics.*;
import com.AlicornLunaa.CellularSimulation.rendering.*;
import com.AlicornLunaa.CellularSimulation.util.*;
import org.joml.Vector2i;

// Holds every cell
public class World {

    // Static variables
    public static final float CELL_SPACING = 1.f;

    // Variables
    private CellRenderer renderer;
    private Physics physics;
    private Camera worldCamera;
    private CellGrid grid;

    // Functions
    public String toString(){
        StringBuilder s = new StringBuilder();

        for(int x = 0; x < grid.getWidth(); x++){
            for(int y = 0; y < grid.getHeight(); y++){
                s.append(grid.getCell(x, y).getName()).append(" ");
            }

            s.append("\n");
        }

        return s.toString();
    }

    public void draw(){
        worldCamera.use(renderer.getShader());
        renderer.draw(grid);
    }

    public void step(){
        physics.step(grid);
    }

    public Shader getShader(){
        return renderer.getShader();
    }
    public Camera getCamera(){ return worldCamera; }
    public CellGrid getGrid(){ return grid; }

    // Constructor
    public World(int width, int height, int size){
        // Initialize grid
        renderer = new CellRenderer();
        physics = new Physics();
        worldCamera = new Camera(width, height);
        grid = new CellGrid(size, size);

        // Test setup
        grid.setCell(Cell.getProton(), 15, 15);
        grid.setCell(Cell.getProton(), 16, 15);
        grid.setCell(Cell.getProton(), 15, 16);
        grid.setCell(Cell.getProton(), 16, 16);
        grid.setCell(new Molecule(2,2,2), 49, 49);
    }

}
