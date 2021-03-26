package com.AlicornLunaa.CellularSimulation.gameplay;

// Holds every cell
public class World {

    private Cell[][] grid;

    public World(int size){
        // Initialize grid
        grid = new Cell[size][size];

        for(int x = 0; x < grid.length; x++){
            for(int y = 0; y < grid[0].length; y++){
                grid[x][y] = Cell.getEmpty();
            }
        }
    }

}
