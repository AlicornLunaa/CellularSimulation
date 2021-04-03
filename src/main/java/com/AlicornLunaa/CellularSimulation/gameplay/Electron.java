package com.AlicornLunaa.CellularSimulation.gameplay;

import com.AlicornLunaa.CellularSimulation.util.Color;
import org.joml.Vector2i;

public class Electron extends Cell {

    // Variables


    // Functions
    @Override
    public void step(World world, int x, int y){
        // Check positions around
        //Cell[] around = world.getSurrounding(x, y, 7);
    }

    // Constructor
    public Electron() {
        super("Electron", "Basic elementary particle", -1.f, 1, new Color(255, 0, 0));

        // Random velocity
        velocity.x = (int)(Math.random() * 3);
        velocity.y = (int)(Math.random() * 3);
    }

}
