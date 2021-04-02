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
        Vector2f pos = Input.getCursorPosition();
        pos.x = (float)((int)pos.x / 11) * 11;
        pos.y = (float)((int)pos.y / 11) * 11;
        cursor.setPosition(new Vector3f(pos, 0.f));

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

        Input.init(windowHandle);
        gui = new Gui(width, height);
        world = new World(width, height,50);

        cursor = new Rectangle(0, 0, 10, 10);
        cursor.color = new Color(255, 0, 255);

        super.start();
    }

    // Entry
    public static void main(String[] args){
        CellularSimulation game = new CellularSimulation();
    }

}
