package com.AlicornLunaa.CellularSimulation.physics;

import com.AlicornLunaa.CellularSimulation.gameplay.*;
import com.AlicornLunaa.CellularSimulation.util.MathUtil;
import org.joml.Vector2f;
import org.joml.Vector2i;

import java.util.ArrayList;

public class Physics {

    // Variables
    ArrayList<Move> moves = new ArrayList<Move>();

    // Functions
    public void updateElectron(CellGrid grid, int x, int y){
        // Move towards protons and away from electrons
        CellGrid nearby = grid.getNeighbors(x, y, 13);

    }

    public void updateNeutron(CellGrid grid, int x, int y){
        // Move towards

    }

    public void updateProton(CellGrid grid, int x, int y){
        // Setup
        CellGrid nearby = grid.getNeighbors(x, y, 13);

    }

    public void updateVelocity(CellGrid grid, int x, int y){
        // Setup
        Cell cell = grid.getCell(x, y);
        int areaInfluenced = Math.max(cell.getVelocity().x, cell.getVelocity().y);

        if(areaInfluenced == 0){ return; } // Skip if not moving anywhere

        Vector2i artificalPosition = new Vector2i(x, y);
        CellGrid nearby = grid.getNeighbors(x, y, areaInfluenced);

        // Get slope to the simplest form as well as the magnitude. Increment by the slope by magnitude times
        int gcd = MathUtil.gcd(cell.getVelocity().x, cell.getVelocity().y);
        Vector2i slope = new Vector2i(cell.getVelocity()).div(gcd);

        // Iterate over the amount of times of the slope
        for(int i = 0; i < gcd; i++){
            artificalPosition.add(slope);

            // Collision check
            if(grid.getCell(artificalPosition.x, artificalPosition.y).getType() != Cell.CellType.EMPTY){
                artificalPosition.sub(slope);
                break;
            }
        }

        // Add to moves if the position is different than current pos
        if(x == artificalPosition.x && y == artificalPosition.y){ return; }
        moves.add(new Move(x, y, artificalPosition.x, artificalPosition.y));
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

            updateVelocity(grid, x, y);
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
