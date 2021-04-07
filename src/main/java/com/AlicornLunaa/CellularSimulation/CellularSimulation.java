package com.AlicornLunaa.CellularSimulation;

import com.AlicornLunaa.CellularSimulation.gameplay.*;
import com.AlicornLunaa.CellularSimulation.rendering.*;
import com.AlicornLunaa.CellularSimulation.util.*;
import org.joml.Vector2f;
import org.joml.Vector3f;

import static org.lwjgl.glfw.GLFW.*;

public class CellularSimulation extends Window {

    // Variables
    private Gui gui;
    private World world;
    private Texture tex;
    private Rectangle cursor;

    // Functions
    @Override
    public void keypress(int key, int scancode, int action, int mods){
        /* Cell actions
        E: Sets all selected to electrons
        N: Sets all selected to neutrons
        P: Sets all selected to protons
         */
        CellGrid grid = world.getGrid();

        if(action == GLFW_PRESS){
            switch(key){
                case GLFW_KEY_E:
                    grid.loopCells((int x, int y, Cell c) -> {
                        if(c.isHighlighted()){
                            c.highlight(false);
                            grid.setCell(new Electron(), x, y);
                        }
                    });
                    break;

                case GLFW_KEY_N:
                    world.getGrid().loopCells((int x, int y, Cell c) -> {
                        if(c.isHighlighted()){
                            c.highlight(false);
                            grid.setCell(Cell.getNeutron(), x, y);
                        }
                    });
                    break;

                case GLFW_KEY_P:
                    grid.loopCells((int x, int y, Cell c) -> {
                        if(c.isHighlighted()){
                            c.highlight(false);
                            grid.setCell(Cell.getProton(), x, y);
                        }
                    });
                    break;

                case GLFW_KEY_DELETE:
                    grid.loopCells((int x, int y, Cell c) -> {
                        if(c.isHighlighted()){
                            c.highlight(false);
                            grid.setCell(Cell.getEmpty(), x, y);
                        }
                    });
                    break;

                case GLFW_KEY_M:
                    grid.loopCells((int x, int y, Cell c) -> {
                        if(c.isHighlighted()){
                            c.highlight(false);
                            grid.setCell(new Molecule(6, 6, 6), x, y);
                        }
                    });
                    break;

                case GLFW_KEY_1:
                    ((Molecule)grid.getCell(25, 18)).addElectron(1);
                    break;

                case GLFW_KEY_2:
                    ((Molecule)grid.getCell(25, 18)).addElectron(-1);
                    break;

                case GLFW_KEY_SPACE:
                    world.step();
                    break;
            }
        }
    }

    @Override
    public void render(){
        // Inputs
        Vector2f pos = Input.getCursorPosition();
        int xSelect = ((int)pos.x / 11);
        int ySelect = ((int)pos.y / 11);
        cursor.setPosition(new Vector3f(xSelect * 11, ySelect * 11, 0.f));

        if(glfwGetMouseButton(windowHandle, GLFW_MOUSE_BUTTON_LEFT) == GLFW_PRESS){
            world.getGrid().getCell(xSelect, ySelect).highlight(true);
        } else if(glfwGetMouseButton(windowHandle, GLFW_MOUSE_BUTTON_RIGHT) == GLFW_PRESS){
            world.getGrid().getCell(xSelect, ySelect).highlight(false);
        }

        // Cell render
        world.getShader().use();
        world.draw();
        world.getShader().unuse();

        // GUI render
        gui.getShader().use();
        gui.draw();
        tex.use();
        cursor.draw(gui.getShader());
        gui.getShader().unuse();
    }

    // Constructor
    public CellularSimulation(){
        super("Cellular Simulation", 1440, 810);

        Input.init(windowHandle);
        gui = new Gui(width, height);
        world = new World(width, height,50);

        tex = new Texture("/textures/cursor.png");
        cursor = new Rectangle(0, 0, 10, 10);
        cursor.color = new Color(255, 0, 100);

        super.start();
    }

    // Entry
    public static void main(String[] args){
        CellularSimulation game = new CellularSimulation();
    }

}
