package org.example.Units;

import java.util.ArrayList;
import java.util.List;


public abstract class Man implements GameInterface {


    String state = "";
    protected int maxHealth;
    String name;
    protected int health,damageMin,damageMax,armor,speed;
    protected Vector2D coords;
    protected int attack;


    public Man(String state, int maxHealth, int posX, int posY, String name, int health, int damageMin, int damageMax, int armor, int speed, int attack) {
        coords = new Vector2D(posX,posY);
        this.state = state;
        this.maxHealth = maxHealth;
        this.name = name;
        this.health = health;
        this.damageMin = damageMin;
        this.damageMax = damageMax;
        this.armor = armor;
        this.speed = speed;
        this.attack = attack;
    }

    @Override
    public String getInfo(){return "Я крестьянин!";}

    @Override
    public void step(List<Man> team1, List<Man> team2) {

    }

    public int getSpeed() {
        return speed;
    }
    public void setCoords(Vector2D coords) {
        this.coords = coords;
    }

    //Поиск минимальной дистанции.
    protected int findNearest(List<Man> team2){
        double min = 100;
        int index = -1;
        for (int i = 0; i < team2.size(); i++) {
            //Если его дистанция меньше минимального значения и противник не мёртв
            if (min > coords.getDistance(team2.get(i).coords) & !team2.get(i).state.equals("Die")) {
                    index = i;
                    min = coords.getDistance(team2.get(i).coords);
                }
        }
        return index;
    }


    protected void getDamage(float damage){
        health-=damage;
        if (health > maxHealth) health = maxHealth;
        if (health <= 0) state = "Die";
    }

    public String toInfo() {
        return "Имя: "+ name +
                "\t\tСостояние: "+ state +
                "\t\tЗдоровье: "+ health +
                "\t\tБроня: " + armor +
                "\t\tУрон min: " + damageMin +
                "\t\tУрон max: " + damageMax +
                "\t\tКоординаты: (X:"+ coords.posX+"; Y:"+ coords.posY+")";
    }
}

