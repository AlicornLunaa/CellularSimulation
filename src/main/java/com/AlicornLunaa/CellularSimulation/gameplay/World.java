package com.AlicornLunaa.CellularSimulation.gameplay;

import com.AlicornLunaa.CellularSimulation.physics.Physics;
import com.AlicornLunaa.CellularSimulation.rendering.Camera;
import com.AlicornLunaa.CellularSimulation.rendering.CellRenderer;
import com.AlicornLunaa.CellularSimulation.rendering.Shader;
import com.AlicornLunaa.CellularSimulation.util.CellLoopCallback;
import org.joml.Vector3f;

// Holds every cell
public class World {

    // Static variables
    public static final float CELL_SPACING = 1.f;

    // Variables
    private CellRenderer renderer;
    private Physics physics;
    private Camera worldCamera;
    private Cell[][] grid;

    // Functions
    public String toString(){
        StringBuilder s = new StringBuilder();

        for(int x = 0; x < grid[0].length; x++){
            for(int y = 0; y < grid.length; y++){
                s.append(grid[y][x].getName()).append(" ");
            }

            s.append("\n");
        }

        return s.toString();
    }

    public void setCell(int x, int y, Cell cell){
        grid[y][x] = cell;
    }

    public Cell getCell(int x, int y){ return grid[y][x]; }

    public void swapCell(int x1, int y1, int x2, int y2){
        Cell temp = grid[y1][x1];
        grid[y1][x1] = grid[y2][x2];
        grid[y2][x2] = temp;
    }

    public Cell[] getSurrounding(int x, int y, int range){
        Cell[] surrounding = new Cell[range * range];

        int i = 0;
        for(int rX = -range/2; rX < range/2 + 1; rX++) for(int rY = -range/2; rY < range/2 + 1; rY++){
            if(x + rX < 0 || y + rY < 0 || x + rX > grid[0].length || y + rY > grid.length){
                surrounding[i] = null;
            } else {
                surrounding[i] = grid[y + rY][x + rX];
            }

            i++;
        }

        return surrounding;
    }

    public void loopCells(CellLoopCallback func){
        for(int x = 0; x < grid[0].length; x++){
            for(int y = 0; y < grid.length; y++){
                func.invoke(x, y, grid[y][x]);
            }
        }
    }

    public void draw(){
        worldCamera.use(renderer.getShader());
        renderer.draw(grid);
    }

    public Shader getShader(){
        return renderer.getShader();
    }

    public Camera getCamera(){ return worldCamera; }

    public void step(){
        physics.step(this);
    }

    // Constructor
    public World(int width, int height, int size){
        // Initialize grid
        renderer = new CellRenderer();
        physics = new Physics();
        worldCamera = new Camera(width, height);
        grid = new Cell[size][size];

        for(int x = 0; x < grid[0].length; x++){
            for(int y = 0; y < grid.length; y++){
                grid[y][x] = Cell.getEmpty();
            }
        }
    }

}
