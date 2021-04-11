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
        Cell cell = grid.getCell(x, y);
        CellGrid nearby = grid.getNeighbors(x, y, 13);
        Vector2i center = nearby.getCenter();

        // Electron velocity update
        nearby.loopCells((int mX, int mY, Cell c) -> {
            // Skip self
            if(mX == center.x && mY == center.y){ return; }
            int xDir = center.x - mX; int yDir = center.y - mY;

            // Check types
            switch(c.getType()){
                case ELECTRON:
                    // Increment velocity by this number
                    cell.getVelocity().add(xDir / 2, yDir / 2);
                    break;

                case PROTON:
                    // Increment velocity by this number
                    cell.getVelocity().add(xDir / -2, yDir / -2);
                    break;
            }
        });
    }

    public void updateNeutron(CellGrid grid, int x, int y){
        // Move towards protons but in a small radius
        Cell cell = grid.getCell(x, y);
        CellGrid nearby = grid.getNeighbors(x, y, 7);
        Vector2i center = nearby.getCenter();

        // Neutron velocity update
        nearby.loopCells((int mX, int mY, Cell c) -> {
            // Skip self
            if(mX == center.x && mY == center.y){ return; }
            int xDir = center.x - mX; int yDir = center.y - mY;

            // Check types
            if(c.getType() == Cell.CellType.PROTON){
                // Increment velocity by this number
                cell.getVelocity().add(-xDir, -yDir);
            }
        });
    }

    public void updateProton(CellGrid grid, int x, int y){
        // Move away from protons and towards electrons
        Cell cell = grid.getCell(x, y);
        CellGrid nearby = grid.getNeighbors(x, y, 13);
        Vector2i center = nearby.getCenter();
        final boolean[] exists = {true};

        // Proton velocity update
        nearby.loopCells((int mX, int mY, Cell c) -> {
            // Skip self
            if(!exists[0]){ return; }
            if(mX == center.x && mY == center.y){ return; }
            int xDir = center.x - mX; int yDir = center.y - mY;

            // Check types
            switch(c.getType()){
                case PROTON:
                    // Increment velocity by this number
                    cell.getVelocity().add(xDir / 2, yDir / 2);
                    break;

                case ELECTRON:
                    // Increment velocity by this number
                    cell.getVelocity().add(xDir / -2, yDir / -2);

                    // If cell distance is under 2, convert to molecule
                    if(xDir <= 2 && yDir <= 2){
                        grid.setCell(Cell.getEmpty(), (mX - center.x) + x, (mY - center.y) + y);
                        grid.setCell(Cell.getEmpty(), x, y);
                        grid.setCell(new Molecule(1, 0, 1), x, y);
                        exists[0] = false;
                    }
                    break;
            }
        });
    }

    public void updateMolecule(CellGrid grid, int x, int y){
        // Setup
        Molecule molecule = (Molecule)grid.getCell(x, y);
        CellGrid nearby = grid.getNeighbors(x, y, (int)molecule.getInfluenceSphere());
        Vector2i center = nearby.getCenter();

        nearby.loopCells((int mX, int mY, Cell c) -> {
            // Count each type and add accordingly
            if(c == null){ return; }
            if(mX == center.x && mY == center.y){ return; }
            int gridSpaceX = (mX - center.x) + x;
            int gridSpaceY = (mY - center.y) + y;

            switch(c.getType()){
                case PROTON:
                    molecule.addProton(1);
                    grid.setCell(Cell.getEmpty(), gridSpaceX, gridSpaceY);
                    break;
                case NEUTRON:
                    molecule.addNeutron(1);
                    grid.setCell(Cell.getEmpty(), gridSpaceX, gridSpaceY);
                    break;
                case ELECTRON:
                    molecule.addElectron(1);
                    grid.setCell(Cell.getEmpty(), gridSpaceX, gridSpaceY);
                    break;
                case MOLECULE:
                    Molecule m = (Molecule)c;
                    molecule.addProton(m.getProtons());
                    molecule.addNeutron(m.getNeutrons());
                    molecule.addElectron(m.getElectrons());
                    grid.setCell(Cell.getEmpty(), gridSpaceX, gridSpaceY);
                    break;
            }
        });
    }

    public void updateVelocity(CellGrid grid, int x, int y){
        // Setup
        Cell cell = grid.getCell(x, y);
        int areaInfluenced = Math.max(Math.abs(cell.getVelocity().x), Math.abs(cell.getVelocity().y));

        if(areaInfluenced == 0){ return; } // Skip if not moving anywhere

        Vector2i artificalPosition = new Vector2i(x, y);
        CellGrid nearby = grid.getNeighbors(x, y, areaInfluenced);

        // Get slope to the simplest form as well as the magnitude. Increment by the slope by magnitude times
        int gcd = MathUtil.gcd(Math.abs(cell.getVelocity().x), Math.abs(cell.getVelocity().y));
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
                case MOLECULE:
                    updateMolecule(grid, x, y);
                    break;
                default:
                    break;
            }
        });

        grid.loopCells((int x, int y, Cell c) -> {
            if(c.getType() != Cell.CellType.EMPTY){
                updateVelocity(grid, x, y);
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
