package org.example.Units;

import java.util.List;

public class Vector2D{
    int posX,posY;

    public Vector2D(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public Double getDistance(Vector2D opponent){
        return Math.sqrt(Math.pow(opponent.posX-posX,2)+Math.pow(opponent.posY-posY,2));
    }

    //Противник с права или с лева
    protected boolean getLeft(Vector2D opponent){ return opponent.posX < posX; }

    //Противник выше или ниже?
    protected boolean getDown(Vector2D opponent){ return opponent.posY < posY; }

    //Стоит ли ктото на соседней клетке
    protected boolean getEmpty(List<Man> team, int posX, int posY){
        boolean hool = true;
        for (Man man: team){
            if (man.coords.posX == posX & man.coords.posY == posY){
                hool = false;
                break;
            }
        }
        return hool;
    }
}
