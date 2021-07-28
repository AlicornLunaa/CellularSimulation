package com.AlicornLunaa.CellularSimulation.rendering.text;

import com.AlicornLunaa.CellularSimulation.rendering.Shader;
import org.joml.Vector2f;

public class Text {

    // Variables
    private Vector2f position;
    private String string;

    // Functions
    public void draw(Shader shader){

    }

    public String getString(){ return string; }
    public void setString(String string){ this.string = string; }

    // Constructor
    public Text(float x, float y, String string){

    }

}
