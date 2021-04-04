package com.AlicornLunaa.CellularSimulation.gameplay;

import com.AlicornLunaa.CellularSimulation.util.CellLoopCallback;
import org.joml.Vector2i;

public class CellGrid {

    // Variables
    private int width;
    private int height;
    private Cell[] cells;

    // Functions
    private int XY2ID(int x, int y){ return (x + y * width); }
    private Vector2i ID2XY(int id){ return new Vector2i(id % width, id / width); }

    public void swapCell(int x1, int y1, int x2, int y2){
        Cell temp = cells[XY2ID(x1, y1)];
        cells[XY2ID(x1, y1)] = cells[XY2ID(x2, y2)];
        cells[XY2ID(x2, y2)] = temp;
    }

    public CellGrid getSurrounding(int x, int y, int range){
        CellGrid grid = new CellGrid(range, range);

        for(int rX = -range/2; rX < range/2 + 1; rX++) for(int rY = -range/2; rY < range/2 + 1; rY++){
            if(x + rX < 0 || y + rY < 0 || x + rX > width || y + rY > height){
                grid.setCell(null, rX, rY);
            } else {
                grid.setCell(cells[XY2ID(x + rX, y + rY)], rX, rY);
            }
        }

        return grid;
    }

    public void loopCells(CellLoopCallback func){
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                func.invoke(x, y, cells[XY2ID(x, y)]);
            }
        }
    }

    // Setters
    public void setCell(Cell cell, int x, int y){ cells[XY2ID(x, y)] = cell; }

    // Getters
    public Cell getCell(int x, int y){ return cells[XY2ID(x, y)]; }

    // Constructor
    public CellGrid(int width, int height){
        this.width = width;
        this.height = height;

        cells = new Cell[width * height];
    }

}
