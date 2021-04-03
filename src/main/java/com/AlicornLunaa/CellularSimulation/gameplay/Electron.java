package com.AlicornLunaa.CellularSimulation.gameplay;

import com.AlicornLunaa.CellularSimulation.util.Color;

public class Electron extends Cell {

    // Variables


    // Functions
    @Override
    public void step(World world, int x, int y){
        // Check positions around
        Cell[] around = new Cell[8];
        around[0] = world.getCell(x - 1, y - 1);
        around[1] = world.getCell(x, y - 1);
        around[2] = world.getCell(x + 1, y - 1);
        around[3] = world.getCell(x - 1, y);
        around[4] = world.getCell(x + 1, y);
        around[5] = world.getCell(x - 1, y + 1);
        around[6] = world.getCell(x, y + 1);
        around[7] = world.getCell(x + 1, y + 1);


    }

    // Constructor
    public Electron() {
        super("Electron", "Basic elementary particle", -1.f, 1, new Color(255, 0, 0));
    }

}
