package com.AlicornLunaa.CellularSimulation.rendering;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;

public class Camera {

    // Variables
    public Vector3f position;
    public float zoom;

    private FloatBuffer matrixBuffer;
    private Matrix4f viewMatrix;
    private Matrix4f projMatrix;

    // Functions
    public void use(Shader shader){
        viewMatrix.translation(position);
        viewMatrix.scale(zoom, zoom, zoom);

        shader.setUniform("viewMatrix", viewMatrix.get(matrixBuffer));
        shader.setUniform("projMatrix", projMatrix.get(matrixBuffer));
    }

    // Constructor
    public Camera(int width, int height){
        position = new Vector3f();
        zoom = 1.f;

        matrixBuffer = BufferUtils.createFloatBuffer(16);
        viewMatrix = new Matrix4f();
        projMatrix = new Matrix4f().ortho(0, width, height, 0, -10, 10);
    }

}
