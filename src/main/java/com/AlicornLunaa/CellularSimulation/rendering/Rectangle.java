package com.AlicornLunaa.CellularSimulation.rendering;

import com.AlicornLunaa.CellularSimulation.util.*;

import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;

import java.nio.FloatBuffer;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.system.MemoryUtil.*;

public class Rectangle {

    // Variables
    private int vao;
    private int vbo;
    private Vector3 position;
    private Vector3 rotation;
    private Vector3 scale;
    private Color color;

    // Functions
    private void initObjectData(){
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        FloatBuffer buffer = BufferUtils.createFloatBuffer(3 * 6);
        buffer.put(0.5f).put(0.5f).put(-0.5f);
        buffer.put(0.5f).put(-0.5f).put(-0.5f);
        buffer.put(-0.5f).put(-0.5f).put(-0.5f);
        buffer.put(-0.5f).put(-0.5f).put(-0.5f);
        buffer.put(-0.5f).put(0.5f).put(-0.5f);
        buffer.put(0.5f).put(0.5f).put(-0.5f);
        buffer.flip();

        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, buffer, GL_STATIC_DRAW);
        glEnableVertexAttribArray(0);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0L);

        glBindVertexArray(0);
    }

    public void draw(){
        glBindVertexArray(vao);
        glDrawArrays(GL_TRIANGLES, 0, 3 * 2);
        glBindVertexArray(0);
    }

    // Constructors
    public Rectangle(float x, float y, float width, float height){
        initObjectData();
    }

}
