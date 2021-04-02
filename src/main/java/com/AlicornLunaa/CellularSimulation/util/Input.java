package com.AlicornLunaa.CellularSimulation.util;

import org.joml.Vector2f;
import org.lwjgl.BufferUtils;

import static org.lwjgl.glfw.GLFW.*;

import java.nio.DoubleBuffer;

public class Input {

    private Input(){}

    public static Vector2f getCursorPosition(long window){
        DoubleBuffer xBuf = BufferUtils.createDoubleBuffer(1);
        DoubleBuffer yBuf = BufferUtils.createDoubleBuffer(1);
        glfwGetCursorPos(window, xBuf, yBuf);

        return new Vector2f((float)xBuf.get(0), (float)yBuf.get(0));
    }

}
