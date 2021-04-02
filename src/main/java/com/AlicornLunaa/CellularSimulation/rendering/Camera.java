package com.AlicornLunaa.CellularSimulation.rendering;

import com.AlicornLunaa.CellularSimulation.util.Matrix4f;
import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;

public class Camera {

    // Variables
    FloatBuffer matrixBuffer;
    Matrix4f viewMatrix;
    Matrix4f projMatrix;

    // Functions
    public void use(Shader shader){

    }

    // Constructor
    public Camera(){
        matrixBuffer = BufferUtils.createFloatBuffer(16);

        projMatrix = Matrix4f.ortho(-10, 10, 10, -10, -10, 10);
    }

}
