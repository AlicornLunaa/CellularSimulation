package com.AlicornLunaa.CellularSimulation.rendering;

import com.AlicornLunaa.CellularSimulation.util.*;

import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector2f;
import org.joml.Vector3f;
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

    private Vector3f position = new Vector3f();
    private Quaternionf orientation = new Quaternionf();
    private Vector2f size = new Vector2f();

    public Color color;

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
        modelMatrix.translationRotateScale(position, orientation, new Vector3f(size, 1.f));
        shader.setUniform("modelMatrix", modelMatrix.get(matrixBuffer));
        shader.setUniform("color", color);

        glBindVertexArray(vao);
        glDrawArrays(GL_TRIANGLES, 0, 3 * 2);
        glBindVertexArray(0);
    }

    // Setters
    public void setPosition(Vector3f p){
        position = p.add(new Vector3f(size.x / 2.f, size.y / 2.f, 0.f));
    }

    public void setRotation(Vector3f r){
        orientation.rotateXYZ(r.x, r.y, r.z);
    }

    public void setSize(Vector2f s){
        size = s;
    }

    // Getters
    public Vector3f getPosition(){ return position; }
    public Quaternionf getRotation(){ return orientation; }
    public Vector2f getSize(){ return size; }

    // Constructors
    public Rectangle(float x, float y, float width, float height){
        setSize(new Vector2f(width, height));
        setPosition(new Vector3f(x, y, 0.f));
        color = new Color(255, 127, 10);

        initMatrix();
        initObjectData();
    }

}
