package com.AlicornLunaa.CellularSimulation.rendering;

import com.AlicornLunaa.CellularSimulation.util.*;

import org.joml.Matrix4f;
import org.joml.Vector2f;
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
    private FloatBuffer matrixBuffer;
    private Matrix4f modelMatrix;

    private int vao;
    private int vbo;
    private Vector2f position;
    private Vector2f rotation;
    private Vector2f scale;
    private Color color;

    // Functions
    private void initMatrix(){
        matrixBuffer = BufferUtils.createFloatBuffer(16);
        modelMatrix = new Matrix4f();
    }

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

    public void draw(Shader shader){
        shader.setUniform("modelMatrix", modelMatrix.get(matrixBuffer));

        glBindVertexArray(vao);
        glDrawArrays(GL_TRIANGLES, 0, 3 * 2);
        glBindVertexArray(0);
    }

    // Constructors
    public Rectangle(float x, float y, float width, float height){
        initMatrix();
        initObjectData();
    }

}
