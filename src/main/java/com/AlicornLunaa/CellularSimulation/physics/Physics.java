package com.AlicornLunaa.CellularSimulation.physics;

import com.AlicornLunaa.CellularSimulation.gameplay.World;

public class Physics {

    // Variables

    // Functions
    public void step(World world){
        world.swapCell(0, 0, 1, 0);
    }

    // Constructor
    public Physics(){

    }

}
