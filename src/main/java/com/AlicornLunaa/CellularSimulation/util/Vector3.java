package com.AlicornLunaa.CellularSimulation.util;

public class Vector3 {

    // Variables
    public float x, y, z;

    // Functions
    public Vector3 toRadians(){
        Vector3 res = new Vector3();

        res.x = (float)Math.toRadians(x);
        res.y = (float)Math.toRadians(y);
        res.z = (float)Math.toRadians(y);

        return res;
    }

    // Constructors
    public Vector3(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3(){
        this.x = 0.f;
        this.y = 0.f;
        this.z = 0.f;
    }

}
