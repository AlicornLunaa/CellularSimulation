package com.AlicornLunaa.CellularSimulation;

import com.AlicornLunaa.CellularSimulation.gameplay.*;
import com.AlicornLunaa.CellularSimulation.rendering.*;
import com.AlicornLunaa.CellularSimulation.util.*;

import static org.lwjgl.glfw.GLFW.*;

public class CellularSimulation extends Window {

    // Variables
    Shader shader;
    World world;
    Camera camera;

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
        // Init render
        world.getShader().use();
        camera.use(world.getShader());
        world.draw();
        world.getShader().unuse();
    }

    // Constructor
    public CellularSimulation(){
        super("Cellular Simulation", 1440, 810);

        shader = new Shader("/shaders/default.vs", "/shaders/default.fs");
        world = new World(50);
        camera = new Camera(1440, 810);

        super.start();
    }

    // Entry
    public static void main(String[] args){
        CellularSimulation game = new CellularSimulation();
    }

}
