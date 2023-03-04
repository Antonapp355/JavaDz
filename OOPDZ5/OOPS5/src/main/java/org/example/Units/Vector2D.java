package org.example.Units;

import java.util.List;

public class Vector2D{
    int posX,posY;

    public Vector2D(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public Double getDistance(Vector2D oppanent){
        return Math.sqrt(Math.pow(posX-oppanent.posX,2)+Math.pow(posY-oppanent.posY,2));
    }
}
