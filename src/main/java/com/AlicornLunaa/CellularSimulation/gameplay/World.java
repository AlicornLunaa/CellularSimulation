package com.AlicornLunaa.CellularSimulation.gameplay;

import com.AlicornLunaa.CellularSimulation.rendering.Camera;
import com.AlicornLunaa.CellularSimulation.rendering.CellRenderer;
import com.AlicornLunaa.CellularSimulation.rendering.Shader;

// Holds every cell
public class World {

    // Variables
    private CellRenderer renderer;
    private Camera worldCamera;
    private Cell[][] grid;

    // Functions
    public String toString(){
        StringBuilder s = new StringBuilder();

        for(int x = 0; x < grid[0].length; x++){
            for(int y = 0; y < grid.length; y++){
                s.append(grid[y][x].getName()).append(" ");
            }

            s.append("\n");
        }

        return s.toString();
    }

    public void setCell(int x, int y, Cell cell){
        grid[x][y] = cell;
    }

    public void draw(){
        worldCamera.use(renderer.getShader());
        renderer.draw(grid);
    }

    public Shader getShader(){
        return renderer.getShader();
    }

    public Camera getCamera(){ return worldCamera; }

    // Constructor
    public World(int width, int height, int size){
        // Initialize grid
        renderer = new CellRenderer();
        worldCamera = new Camera(width, height);
        grid = new Cell[size][size];

        for(int x = 0; x < grid[0].length; x++){
            for(int y = 0; y < grid.length; y++){
                grid[y][x] = Cell.getEmpty();
            }
        }
    }

}
