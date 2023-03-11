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

    protected int delivery;


    public Man(String state, int maxHealth, int posX, int posY, String name, int health, int damageMin, int damageMax, int armor, int speed, int attack, int delivery) {
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
        this.delivery = delivery;
    }

    @Override
    public String getInfo(){return "Крестьянин!";}

    @Override
    public void step(List<Man> team1, List<Man> team2) {}

    public int[] getCoords() {return new int[]{coords.posX, coords.posY};}
    public float getHp() { return health;}

    public int getSpeed() {
        return speed;
    }

    //Поиск минимальной дистанции.
    protected int findNearest(List<Man> team){
        double min = 100;
        int index = -1;
        for (int i = 0; i < team.size(); i++) {

            //Если его дистанция меньше минимального значения и противник не мёртв
            if (min > coords.getDistance(team.get(i).coords) & !team.get(i).state.equals("Die")) {
                    index = i;
                    min = coords.getDistance(team.get(i).coords);
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
        return  getInfo() +
                " "+state +
                " HP: "+ health +
                " Arm: " + armor +
                " Pos: (X:"+ coords.posX+"; Y:"+ coords.posY+")";
    }
}

