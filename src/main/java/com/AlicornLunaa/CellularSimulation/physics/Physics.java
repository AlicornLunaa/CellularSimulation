package com.AlicornLunaa.CellularSimulation.physics;

import com.AlicornLunaa.CellularSimulation.gameplay.Cell;
import com.AlicornLunaa.CellularSimulation.gameplay.Move;
import com.AlicornLunaa.CellularSimulation.gameplay.World;
import org.joml.Vector2f;

import java.util.ArrayList;

public class Physics {

    // Variables
    ArrayList<Move> moves = new ArrayList<Move>();

    // Functions
    public void updateElectron(World world, int x, int y){
        // Move towards protons
        int radius = 9;
        Cell[] nearby = world.getSurrounding(x, y, radius);
        for(int i = 0; i < nearby.length; i++){
            Cell c = nearby[i];
            int relY = i % radius;
            int relX = i / radius;

            if(c == null) continue;

            if(c.getType() == Cell.CellType.PROTON){
                Vector2f direction = new Vector2f(relX - radius / 2, relY - radius / 2);
                direction.normalize();

                if(Math.abs(direction.x) > Math.abs(direction.y)){
                    // X is greater than the Y, therefore move in the X direction
                    moves.add(new Move(x, y, x + (int)Math.signum(direction.x), y));
                } else {
                    // Y is greater than the X, therefore move in the Y direction
                    moves.add(new Move(x, y, x, y + (int)Math.signum(direction.y)));
                }
            }
        }
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
                default:
                    break;
            }
        });

        for(Move m : moves){
            world.swapCell(m.x1, m.y1, m.x2, m.y2);
        }

        moves.clear();
    }

    // Constructor
    public Physics(){

    }

}
