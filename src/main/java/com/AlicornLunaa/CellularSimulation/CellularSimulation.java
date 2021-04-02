package com.AlicornLunaa.CellularSimulation;

import com.AlicornLunaa.CellularSimulation.gameplay.*;
import com.AlicornLunaa.CellularSimulation.rendering.*;
import com.AlicornLunaa.CellularSimulation.util.*;
import org.joml.Vector3f;

import static org.lwjgl.glfw.GLFW.*;

public class CellularSimulation extends Window {

    // Variables
    private Gui gui;
    private World world;
    private Rectangle cursor;

    // Functions
    @Override
    public void keypress(int key, int scancode, int action, int mods){
        // Handle clicks
        if(key == GLFW_KEY_A){
            world.getCamera().position.x += 5.f;
        } else if(key == GLFW_KEY_D){
            world.getCamera().position.x -= 5.f;
        } else if(key == GLFW_KEY_W){
            world.getCamera().position.y += 5.f;
        } else if(key == GLFW_KEY_S){
            world.getCamera().position.y -= 5.f;
        } else if(key == GLFW_KEY_Q){
            world.getCamera().zoom += 0.1f;
        } else if(key == GLFW_KEY_E){
            world.getCamera().zoom -= 0.1f;
        }
    }

    @Override
    public void render(){
        // Inputs
        cursor.setPosition(new Vector3f(Input.getCursorPosition(windowHandle).sub(2.5f, 2.5f), 0.f));

        // Cell render
        world.getShader().use();
        world.draw();
        world.getShader().unuse();

        // GUI render
        gui.getShader().use();
        gui.draw();
        cursor.draw(gui.getShader());
        gui.getShader().unuse();
    }

    // Constructor
    public CellularSimulation(){
        super("Cellular Simulation", 1440, 810);

        gui = new Gui(width, height);
        world = new World(width, height,50);

        cursor = new Rectangle(0, 0, 5, 5);
        cursor.color = new Color(255, 0, 0);

        super.start();
    }

    // Entry
    public static void main(String[] args){
        CellularSimulation game = new CellularSimulation();
    }

}
