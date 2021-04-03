package com.AlicornLunaa.CellularSimulation.physics;

import com.AlicornLunaa.CellularSimulation.gameplay.Cell;
import com.AlicornLunaa.CellularSimulation.gameplay.World;

public class Physics {

    // Variables

    // Functions
    public void step(World world){
        world.loopCells((int x, int y, Cell c) -> {
            c.step(world, x, y);
        });
    }

    // Constructor
    public Physics(){

    }

}
