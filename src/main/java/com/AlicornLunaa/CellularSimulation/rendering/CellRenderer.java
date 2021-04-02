package com.AlicornLunaa.CellularSimulation.rendering;

// Draws all the cells using instancing since they'll all share the same shape

public class CellRenderer {

    // Variables
    private Shader cellShader;

    // Constructor
    public CellRenderer(){
        // Initialize shader
        cellShader = new Shader("/shaders/cell.vs", "/shaders/cell.fs", "/shaders/cell.gs");
    }

}
