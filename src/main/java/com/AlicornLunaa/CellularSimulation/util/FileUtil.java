package com.AlicornLunaa.CellularSimulation.util;

import com.AlicornLunaa.CellularSimulation.CellularSimulation;
import de.matthiasmann.twl.utils.PNGDecoder;
import org.lwjgl.BufferUtils;

import java.io.*;
import java.nio.*;

public final class FileUtil {

    private FileUtil(){}

    public static String loadAsString(String path) {
        String res = "";

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(CellularSimulation.class.getResourceAsStream(path)));
            String buffer = "";

            while ((buffer = reader.readLine()) != null) {
                res += buffer + "\n";
            }

            reader.close();
        } catch(IOException e){
            e.printStackTrace();
        }

        return res;
    }

    public static ByteBuffer loadTextureAsBytes(String path, IntBuffer width, IntBuffer height){
        ByteBuffer data = null;
        
        try {
            PNGDecoder decoder = new PNGDecoder(FileUtil.class.getResourceAsStream(path));
            data = BufferUtils.createByteBuffer(4 * decoder.getWidth() * decoder.getHeight());

            decoder.decode(data, 4 * decoder.getWidth(), PNGDecoder.Format.RGBA);
            data.flip();

            width.put(decoder.getWidth());
            height.put(decoder.getHeight());
            width.rewind();
            height.rewind();
        } catch(IOException e){
            e.printStackTrace();
        }

        return data;
    }

}
