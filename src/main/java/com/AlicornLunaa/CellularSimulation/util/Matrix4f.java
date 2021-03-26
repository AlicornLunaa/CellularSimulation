package com.AlicornLunaa.CellularSimulation.util;

public class Matrix4f {

    // Variables
    private float[] mMatrix = new float[16];

    // Functions
    public Matrix4f multiply(Matrix4f matrix){
        Matrix4f res = new Matrix4f();

        for(int y = 0; y < 4; y++){
            for(int x = 0; x < 4; x++){
                float sum = 0.f;

                for(int i = 0; i < 4; i++){
                    sum += mMatrix[i + y * 4] * matrix.mMatrix[x + i * 4];
                }

                res.mMatrix[x + y * 4] = sum;
            }
        }

        return res;
    }

    public void set(int x, int y, float value){
        mMatrix[x + y * 4] = value;
    }

    // Static functions
    public static Matrix4f identity(){
        Matrix4f matrix = new Matrix4f();

        matrix.mMatrix[0] = 1.f;
        matrix.mMatrix[5] = 1.f;
        matrix.mMatrix[10] = 1.f;
        matrix.mMatrix[15] = 1.f;

        return matrix;
    }

    public static Matrix4f translate(Vector3 v){
        Matrix4f res = identity();

        res.mMatrix[12] = v.x;
        res.mMatrix[13] = v.y;
        res.mMatrix[14] = v.z;

        return res;
    }

    public static Matrix4f rotate(Vector3 v){
        Vector3 rotation = v.toRadians();
        Matrix4f xMatrix = identity();
        Matrix4f yMatrix = identity();
        Matrix4f zMatrix = identity();

        xMatrix.set(1, 1,  (float)Math.cos(rotation.x));
        xMatrix.set(2, 1, -(float)Math.sin(rotation.x));
        xMatrix.set(1, 2,  (float)Math.sin(rotation.x));
        xMatrix.set(2, 2,  (float)Math.cos(rotation.x));

        yMatrix.set(0, 0,  (float)Math.cos(rotation.y));
        yMatrix.set(2, 0,  (float)Math.sin(rotation.y));
        yMatrix.set(0, 2, -(float)Math.sin(rotation.y));
        yMatrix.set(2, 2,  (float)Math.cos(rotation.y));

        yMatrix.set(0, 0,  (float)Math.cos(rotation.z));
        yMatrix.set(1, 0, -(float)Math.sin(rotation.z));
        yMatrix.set(0, 1,  (float)Math.sin(rotation.z));
        yMatrix.set(1, 1,  (float)Math.cos(rotation.z));

        Matrix4f res = identity();
        res.multiply(xMatrix);
        res.multiply(yMatrix);
        res.multiply(zMatrix);
        return res;
    }

    public static Matrix4f ortho(float left, float right, float bottom, float top, float near, float far){
        Matrix4f res = identity();

        res.set(0, 0, 2.f / (right - left));
        res.set(1, 1, 2.f / (top - bottom));
        res.set(2, 2, 2.f / (near - far));

        res.set(3, 0, (left + right) / (left - right));
        res.set(3, 1, (bottom + top) / (bottom - top));
        res.set(3, 2, (near + far) / (far - near));

        return res;
    }

}
