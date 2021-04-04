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
    private int vboVertex;
    private int vboTexCoord;

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

        FloatBuffer vertexBuffer = BufferUtils.createFloatBuffer(3 * 6);
        vertexBuffer.put(0.5f).put(0.5f).put(-0.5f); // Top right
        vertexBuffer.put(0.5f).put(-0.5f).put(-0.5f); // Bottom right
        vertexBuffer.put(-0.5f).put(-0.5f).put(-0.5f); // Bottom left
        vertexBuffer.put(-0.5f).put(-0.5f).put(-0.5f); // Bottom left
        vertexBuffer.put(-0.5f).put(0.5f).put(-0.5f); // Top left
        vertexBuffer.put(0.5f).put(0.5f).put(-0.5f); // Top right
        vertexBuffer.flip();

        FloatBuffer texCoordBuffer = BufferUtils.createFloatBuffer(2 * 6);
        texCoordBuffer.put(1.f).put(1.f);
        texCoordBuffer.put(1.f).put(0.f);
        texCoordBuffer.put(0.f).put(0.f);
        texCoordBuffer.put(0.f).put(0.f);
        texCoordBuffer.put(0.f).put(1.f);
        texCoordBuffer.put(1.f).put(1.f);
        texCoordBuffer.flip();

        vboVertex = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboVertex);
        glBufferData(GL_ARRAY_BUFFER, vertexBuffer, GL_STATIC_DRAW);
        glEnableVertexAttribArray(0);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0L);

        vboTexCoord = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboTexCoord);
        glBufferData(GL_ARRAY_BUFFER, texCoordBuffer, GL_STATIC_DRAW);
        glEnableVertexAttribArray(1);
        glVertexAttribPointer(1, 2, GL_FLOAT, false, 0, 0L);

        glBindBuffer(GL_ARRAY_BUFFER, 0);
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

    public boolean intersects(Vector2f v){
        // Returns true or false depending on if the position supplied is intersecting
        return Collision.AABB(new Vector2f(position.x, position.y), size, v);
    }

    // Setters
    public void setPosition(Vector3f p){
        position = new Vector3f(p).add(new Vector3f(size.x / 2.f, size.y / 2.f, 0.f));
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
