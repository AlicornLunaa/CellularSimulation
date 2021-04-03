package com.AlicornLunaa.CellularSimulation.rendering;

import com.AlicornLunaa.CellularSimulation.util.FileUtil;
import org.lwjgl.system.MemoryStack;

import java.io.*;
import java.nio.*;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL12.*;
import static org.lwjgl.opengl.GL30.*;

public class Texture {

    // Variables
    private int selector;
    private int textureID;
    private int width;
    private int height;

    // Functions
    private void genTextures(){
        textureID = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, textureID);
        glPixelStorei(GL_UNPACK_ALIGNMENT, 1);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
    }

    public void setSelector(int selector){ this.selector = selector; }

    public void use(){
        glActiveTexture(GL_TEXTURE0 + selector);
        glBindTexture(GL_TEXTURE_2D, textureID);
    }

    // Constructor
    public Texture(String path){
        selector = 0;

        try(MemoryStack stack = MemoryStack.stackPush()) {
            IntBuffer w = stack.mallocInt(1);
            IntBuffer h = stack.mallocInt(1);
            ByteBuffer data = FileUtil.loadTextureAsBytes(path, w, h);

            width = w.get();
            height = h.get();

            genTextures();
            glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, data);
            glGenerateMipmap(GL_TEXTURE_2D);
        }
    }

}
