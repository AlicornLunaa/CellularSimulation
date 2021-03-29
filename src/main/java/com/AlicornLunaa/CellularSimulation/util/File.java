package com.AlicornLunaa.CellularSimulation.util;

import com.AlicornLunaa.CellularSimulation.CellularSimulation;

import java.io.*;

public final class File {

    private File(){}

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

}
