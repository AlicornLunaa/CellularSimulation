package com.AlicornLunaa.CellularSimulation.util;

import org.joml.Vector2f;
import org.lwjgl.BufferUtils;

import static org.lwjgl.glfw.GLFW.*;

import java.nio.DoubleBuffer;

public class Input {

    private Input(){}

    private static long windowHandle;

    public static void init(long windowHandle){
        Input.windowHandle = windowHandle;
    }

    public static Vector2f getCursorPosition(){
        DoubleBuffer xBuf = BufferUtils.createDoubleBuffer(1);
        DoubleBuffer yBuf = BufferUtils.createDoubleBuffer(1);
        glfwGetCursorPos(Input.windowHandle, xBuf, yBuf);

        return new Vector2f((float)xBuf.get(0), (float)yBuf.get(0));
    }

}
