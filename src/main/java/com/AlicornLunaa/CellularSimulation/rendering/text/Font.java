package com.AlicornLunaa.CellularSimulation.rendering.text;

import com.AlicornLunaa.CellularSimulation.util.FileUtil;
import org.lwjgl.BufferUtils;
import org.lwjgl.stb.*;

import static org.lwjgl.stb.STBTruetype.*;

import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;

import static org.lwjgl.opengl.GL11.*;

public class Font {

    // Variables
    private java.awt.Font font;
    private int size = 24;
    private int width = 0;
    private int height = 0;
    private int textureID;

    // Functions
    private void loadFont(String path){
//        textureID = glGenTextures();
//        glBindTexture(GL_TEXTURE_2D, textureID);
//        glTexImage2D(GL_TEXTURE_2D, 0, GL_ALPHA, width,height, 0, GL_ALPHA, GL_UNSIGNED_BYTE, tempBitmap);
//        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
//        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);

//        for (int i = 32; i < 256; i++) {
//            if (i == 127) {
//                continue;
//            }
//            char c = (char) i;
//            BufferedImage ch = createCharImage(font, c, antiAlias);
//
//            imageWidth += ch.getWidth();
//            imageHeight = Math.max(imageHeight, ch.getHeight());
//        }
    }

    // Constructor
    public Font(String name, int type, int size){
        this.size = size;
        font = new java.awt.Font(name, type, size);
    }

}
