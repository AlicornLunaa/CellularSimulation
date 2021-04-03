package com.AlicornLunaa.CellularSimulation.physics;

import com.AlicornLunaa.CellularSimulation.gameplay.Cell;
import com.AlicornLunaa.CellularSimulation.gameplay.World;
import org.joml.Vector2i;

public class Physics {

    // Variables

    // Functions
    public void step(World world){
        world.loopCells((int x, int y, Cell c) -> {
            if(c.getName().equals("Empty")) return;
            c.step(world, x, y);

            // Move in velocity direction
            Vector2i velocity = c.getVelocity();
            Vector2i newPos = new Vector2i(x + velocity.x, y + velocity.y);
            Vector2i worldSize = world.getSize();

            System.out.print(c.getName());
            System.out.println(velocity);

            if(newPos.x < 0 || newPos.x > worldSize.x){ velocity.x = -velocity.x; }
            if(newPos.y < 0 || newPos.y > worldSize.y){ velocity.y = -velocity.y; }

            newPos = new Vector2i(x + velocity.x, y + velocity.y);

            world.swapCell(x, y, newPos.x, newPos.y);
        });
    }

    // Constructor
    public Physics(){

    }

}
