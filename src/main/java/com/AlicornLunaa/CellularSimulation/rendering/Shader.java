package com.AlicornLunaa.CellularSimulation.rendering;

import com.AlicornLunaa.CellularSimulation.util.File;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL32.*;

// Shader class
public class Shader {

    // Variables
    private int program;

    // Functions
    private void initShader(String data, int type){
        int id = glCreateShader(type);
        glShaderSource(id, data);
        glCompileShader(id);

        if(glGetShaderi(id, GL_COMPILE_STATUS) == GL_FALSE){
            System.err.println("Failed to compile shader");
            System.err.println(glGetShaderInfoLog(id, 2048));
        }

        glAttachShader(program, id);
    }

    private void initProgram(String vertex, String fragment, String geometry){
        program = glCreateProgram();
        initShader(File.loadAsString(vertex), GL_VERTEX_SHADER);
        initShader(File.loadAsString(fragment), GL_FRAGMENT_SHADER);

        if(!geometry.equals("")) {
            initShader(File.loadAsString(fragment), GL_GEOMETRY_SHADER);
        }

        glLinkProgram(program);
        glValidateProgram(program);
    }

    // Constructor
    public Shader(String vertex, String fragment){
        initProgram(vertex, fragment, "");
    }

    public Shader(String vertex, String fragment, String geometry){
        initProgram(vertex, fragment, geometry);
    }

}
