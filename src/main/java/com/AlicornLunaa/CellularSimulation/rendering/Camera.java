package com.AlicornLunaa.CellularSimulation.rendering;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;

public class Camera {

    // Variables
    private FloatBuffer matrixBuffer;
    private Matrix4f viewMatrix;
    private Matrix4f projMatrix;

    // Functions
    public void use(Shader shader){
        shader.setUniform("viewMatrix", viewMatrix.get(matrixBuffer));
        shader.setUniform("projMatrix", projMatrix.get(matrixBuffer));
    }

    // Constructor
    public Camera(){
        matrixBuffer = BufferUtils.createFloatBuffer(16);

        viewMatrix = new Matrix4f();
        projMatrix = new Matrix4f().ortho(-10, 10, 10, -10, -10, 10);
    }

}
