package com.AlicornLunaa.CellularSimulation;

import com.AlicornLunaa.CellularSimulation.gameplay.*;
import com.AlicornLunaa.CellularSimulation.rendering.*;
import com.AlicornLunaa.CellularSimulation.util.*;

public class CellularSimulation extends Window {

    // Variables
    Shader shader;
    World world;
    Camera camera;

    Rectangle testShape;

    // Functions
    @Override
    public void keypress(int key, int scancode, int action, int mods){
        // Handle clicks

    }

    @Override
    public void render(){
        // Draw the grid
        shader.use();

        camera.use(shader);
        testShape.draw(shader);

        // Draw all the cells

        shader.unuse();
    }

    // Constructor
    public CellularSimulation(){
        super("Cellular Simulation", 1440, 810);

        shader = new Shader("/shaders/default.vs", "/shaders/default.fs");
        world = new World(5);
        camera = new Camera();

        testShape = new Rectangle(0, 0, 1, 1);

        super.start();
    }

    // Entry
    public static void main(String[] args){
        CellularSimulation game = new CellularSimulation();
    }

}
