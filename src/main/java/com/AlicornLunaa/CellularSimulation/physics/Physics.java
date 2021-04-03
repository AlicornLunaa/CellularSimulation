package com.AlicornLunaa.CellularSimulation.physics;

import com.AlicornLunaa.CellularSimulation.gameplay.Cell;
import com.AlicornLunaa.CellularSimulation.gameplay.World;
import org.joml.Vector2i;

public class Physics {

    // Variables

    // Functions
    public void updateElectron(World world, int x, int y){
        // Move towards protons

    }

    public void updateNeutron(World world, int x, int y){
        // Move towards

    }

    public void updateProton(World world, int x, int y){
        // Move towards

    }

    public void step(World world){
        world.loopCells((int x, int y, Cell c) -> {
            switch(c.getType()){
                case ELECTRON:
                    updateElectron(world, x, y);
                    break;
                case NEUTRON:
                    updateNeutron(world, x, y);
                    break;
                case PROTON:
                    updateProton(world, x, y);
                    break;
            }
        });
    }

    // Constructor
    public Physics(){

    }

}
