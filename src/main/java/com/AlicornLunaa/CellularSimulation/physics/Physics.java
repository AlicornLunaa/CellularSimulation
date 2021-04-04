package com.AlicornLunaa.CellularSimulation.physics;

import com.AlicornLunaa.CellularSimulation.gameplay.*;
import org.joml.Vector2f;

import java.util.ArrayList;

public class Physics {

    // Variables
    ArrayList<Move> moves = new ArrayList<Move>();

    // Functions
    public void updateElectron(CellGrid grid, int x, int y){
        // Move towards protons and away from electrons
        CellGrid nearby = grid.getNeighbors(x, y, 13);

//        for(int i = 0; i < ; i++){
//            Cell c = nearby[i];
//            int relY = i % radius;
//            int relX = i / radius;
//
//            if(c == null) continue;
//
//            if(c.getType() == Cell.CellType.ELECTRON){
//                Vector2f direction = new Vector2f(relX - radius / 2, relY - radius / 2);
//                direction.negate();
//
//                // Movement is allowed
//                if (Math.abs(direction.x) > Math.abs(direction.y)) {
//                    // X is greater than the Y, therefore move in the X direction
//                    moves.add(new Move(x, y, x + (int) Math.signum(direction.x), y));
//                } else {
//                    // Y is greater than the X, therefore move in the Y direction
//                    moves.add(new Move(x, y, x, y + (int) Math.signum(direction.y)));
//                }
//            } else if(c.getType() == Cell.CellType.PROTON){
//                Vector2f direction = new Vector2f(relX - radius / 2, relY - radius / 2);
//
//                // Stop movement if less than 2 distance
//                if(Math.abs(direction.x) < 1 || Math.abs(direction.y) < 1){
//
//                } else {
//                    // Movement is allowed
//                    if (Math.abs(direction.x) > Math.abs(direction.y)) {
//                        // X is greater than the Y, therefore move in the X direction
//                        moves.add(new Move(x, y, x + (int) Math.signum(direction.x), y));
//                    } else {
//                        // Y is greater than the X, therefore move in the Y direction
//                        moves.add(new Move(x, y, x, y + (int) Math.signum(direction.y)));
//                    }
//                }
//            }
//        }
    }

    public void updateNeutron(CellGrid grid, int x, int y){
        // Move towards

    }

    public void updateProton(CellGrid grid, int x, int y){
        // Move towards neutrons
        CellGrid nearby = grid.getNeighbors(x, y, 13);
        nearby.loopCells((int x1, int y1, Cell c) -> {
            c.highlight(true);
        });
//        for(int i = 0; i < nearby.length; i++){
//            Cell c = nearby[i];
//            int relY = i % radius;
//            int relX = i / radius;
//
//            if(c == null) continue;
//
//            if(c.getType() == Cell.CellType.NEUTRON){
//                Vector2f direction = new Vector2f(relX - radius / 2, relY - radius / 2);
//
//                // Try to re-arrange into an atomic nucleus
//                if(Math.abs(direction.x) < 0 || Math.abs(direction.y) < 0){
//                    // Create new molecule and bind them together
//
//                } else {
//                    // Movement is allowed
//                    if (Math.abs(direction.x) > Math.abs(direction.y)) {
//                        // X is greater than the Y, therefore move in the X direction
//                        moves.add(new Move(x, y, x + (int) Math.signum(direction.x), y));
//                    } else {
//                        // Y is greater than the X, therefore move in the Y direction
//                        moves.add(new Move(x, y, x, y + (int) Math.signum(direction.y)));
//                    }
//                }
//            }
//        }

    }

    public void step(CellGrid grid){
        grid.loopCells((int x, int y, Cell c) -> {
            switch(c.getType()){
                case ELECTRON:
                    updateElectron(grid, x, y);
                    break;
                case NEUTRON:
                    updateNeutron(grid, x, y);
                    break;
                case PROTON:
                    updateProton(grid, x, y);
                    break;
                default:
                    break;
            }
        });

        for(Move m : moves){
            grid.swapCell(m.x1, m.y1, m.x2, m.y2);
        }

        moves.clear();
    }

    // Constructor
    public Physics(){

    }

}
