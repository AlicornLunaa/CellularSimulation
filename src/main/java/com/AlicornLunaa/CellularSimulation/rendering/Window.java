package com.AlicornLunaa.CellularSimulation.rendering;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

public class Window {

    // Variables
    private String title;
    private int width;
    private int height;
    private long windowHandle;

    // Functions
    public void keypress(int key, int scancode, int action, int mods){}
    public void render(){}

    private void initGLFW(){
        if(!glfwInit())
            throw new IllegalStateException("GLFW failed to initialize");

        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
    }

    private void initWindow(){
        windowHandle = glfwCreateWindow(width, height, title, NULL, NULL);

        glfwSetKeyCallback(windowHandle, (window, key, scancode, action, mods) -> {
            keypress(key, scancode, action, mods);
        });

        glfwMakeContextCurrent(windowHandle);
        glfwSwapInterval(1);
        glfwShowWindow(windowHandle);
    }

    public void start(){
        GL.createCapabilities();
        glClearColor(0.f, 0.f, 0.f, 0.f);

        while(!glfwWindowShouldClose(windowHandle)){
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            render();

            glfwSwapBuffers(windowHandle);
            glfwPollEvents();
        }
    }

    // Constructor
    public Window(String title, int width, int height){
        GLFWErrorCallback.createPrint(System.err).set();

        this.title = title;
        this.width = width;
        this.height = height;

        initGLFW();
        initWindow();
    }

}
