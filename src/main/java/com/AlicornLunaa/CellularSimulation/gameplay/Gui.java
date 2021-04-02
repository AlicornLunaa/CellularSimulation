package com.AlicornLunaa.CellularSimulation.gameplay;

import com.AlicornLunaa.CellularSimulation.rendering.Camera;
import com.AlicornLunaa.CellularSimulation.rendering.Shader;

public class Gui {

    // Variables
    private Shader guiShader;
    private Camera guiCamera;
    private int width;
    private int height;

    // Functions
    public Shader getShader(){
        return guiShader;
    }

    public Camera getCamera(){
        return guiCamera;
    }

    public void draw(){
        guiCamera.use(guiShader);
    }

    // Constructor
    public Gui(int width, int height){
        // Initialize
        guiShader = new Shader("/shaders/gui.vs", "/shaders/gui.fs");
        guiCamera = new Camera(width, height);

        this.width = width;
        this.height = height;
    }

}
