package com.AlicornLunaa.CellularSimulation.rendering;

// Draws all the cells using instancing since they'll all share the same shape

import com.AlicornLunaa.CellularSimulation.gameplay.Cell;
import org.joml.Vector3f;

public class CellRenderer {

    // Variables
    private Shader cellShader;

    // Functions
    public void draw(Cell[][] grid){
        // Render each cell to the shader
        for(int x = 0; x < grid[0].length; x++){
            for(int y = 0; y < grid.length; y++){
                grid[y][x].getShape().setPosition(new Vector3f(x * 11, y * 11, 0.f));
                grid[y][x].getShape().color = grid[y][x].getColor();
                grid[y][x].getShape().draw(cellShader);
            }
        }
    }

    public Shader getShader(){
        return cellShader;
    }

    // Constructor
    public CellRenderer(){
        // Initialize shader
        cellShader = new Shader("/shaders/cell.vs", "/shaders/cell.fs");
    }

}
