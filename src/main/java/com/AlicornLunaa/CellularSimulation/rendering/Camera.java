package com.AlicornLunaa.CellularSimulation.rendering;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
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
        viewMatrix.scale(zoom, zoom, 1.f);

        shader.setUniform("viewMatrix", viewMatrix.get(matrixBuffer));
        shader.setUniform("projMatrix", projMatrix.get(matrixBuffer));
    }

    public Vector2f toView(Vector2f v) {
        // Returns the vector with the current camera
        Matrix4f matrix = new Matrix4f(projMatrix);
        matrix.mul(viewMatrix);

        Vector4f v4 = new Vector4f(v, 0.f, 0.f);
        v4.mul(matrix);

        return new Vector2f(v4.x, v4.y);
    }

    // Constructor
    public Camera(int width, int height){
        position = new Vector3f();
        zoom = 1.f;

        matrixBuffer = BufferUtils.createFloatBuffer(16);
        viewMatrix = new Matrix4f();
        projMatrix = new Matrix4f().ortho(0, width, height, 0, -10.f, 10.f);
    }

}
