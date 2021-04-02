package com.AlicornLunaa.CellularSimulation.rendering;

import com.AlicornLunaa.CellularSimulation.util.Color;
import com.AlicornLunaa.CellularSimulation.util.File;

import java.nio.FloatBuffer;

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

    public void use(){
        glUseProgram(program);
    }

    public void unuse(){
        glUseProgram(0);
    }

    public void setUniform(String attrib, FloatBuffer data){
        int loc = glGetUniformLocation(program, attrib);
        glUniformMatrix4fv(loc, false, data);
    }

    public void setUniform(String attrib, Color color){
        int loc = glGetUniformLocation(program, attrib);
        glUniform3f(loc, color.r / 255.f, color.g / 255.f, color.b / 255.f);
    }

    // Constructor
    public Shader(String vertex, String fragment){
        initProgram(vertex, fragment, "");
    }

    public Shader(String vertex, String fragment, String geometry){
        initProgram(vertex, fragment, geometry);
    }

}
