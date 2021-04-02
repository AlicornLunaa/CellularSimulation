package com.AlicornLunaa.CellularSimulation.util;

import org.joml.Vector2f;

public class Collision {

    private Collision(){}

    public static boolean AABB(Vector2f boxPosition, Vector2f boxSize, Vector2f positionToCheck){
        if(positionToCheck.x <= boxPosition.x + boxSize.x && positionToCheck.x >= boxPosition.x){
            if(positionToCheck.y <= boxPosition.y + boxSize.y && positionToCheck.y >= boxPosition.y){
                return true;
            }
        }

        return false;
    }

}
