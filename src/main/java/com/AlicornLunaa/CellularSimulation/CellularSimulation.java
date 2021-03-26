package com.AlicornLunaa.CellularSimulation;

import com.AlicornLunaa.CellularSimulation.gameplay.*;
import com.AlicornLunaa.CellularSimulation.rendering.*;

public class CellularSimulation extends Window {

    // Variables
    World world;

    // Functions
    @Override
    public void keypress(int key, int scancode, int action, int mods){
        // Handle clicks

    }

    @Override
    public void render(){
        // Draw the grid


        // Draw all the cells
    }

    // Constructor
    public CellularSimulation(){
        super("Cellular Simulation", 1440, 810);
        world = new World(5);
        super.start();
    }

    // Entry
    public static void main(String[] args){
        CellularSimulation game = new CellularSimulation();
    }

}
