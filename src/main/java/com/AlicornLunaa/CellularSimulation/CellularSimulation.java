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
    private Camera camera;
    private Rectangle cursor;

    // Functions
    @Override
    public void keypress(int key, int scancode, int action, int mods){
        // Handle clicks
        if(key == GLFW_KEY_A){
            camera.position.x += 5.f;
        } else if(key == GLFW_KEY_D){
            camera.position.x -= 5.f;
        } else if(key == GLFW_KEY_W){
            camera.position.y += 5.f;
        } else if(key == GLFW_KEY_S){
            camera.position.y -= 5.f;
        } else if(key == GLFW_KEY_Q){
            camera.zoom += 0.1f;
        } else if(key == GLFW_KEY_E){
            camera.zoom -= 0.1f;
        }
    }

    @Override
    public void render(){
        // Inputs
        cursor.setPosition(new Vector3f(Input.getCursorPosition(windowHandle).sub(2.5f, 2.5f), 0.f));
        System.out.println(cursor.intersects(Input.getCursorPosition(windowHandle)));

        // Cell render
        world.getShader().use();
        world.draw();
        world.getShader().unuse();

        // GUI render
        gui.getShader().use();
        gui.draw();
        gui.getShader().unuse();
    }

    // Constructor
    public CellularSimulation(){
        super("Cellular Simulation", 1440, 810);

        gui = new Gui(width, height);
        world = new World(width, height,50);
        camera = new Camera(width, height);

        cursor = new Rectangle(0, 0, 5, 5);
        cursor.color = new Color(255, 0, 0);

        super.start();
    }

    // Entry
    public static void main(String[] args){
        CellularSimulation game = new CellularSimulation();
    }

}
