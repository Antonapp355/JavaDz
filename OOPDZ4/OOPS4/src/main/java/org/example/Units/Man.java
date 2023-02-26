package org.example.Units;

import java.util.List;
import java.util.Random;

public abstract class Man extends Vector2D implements GameInterface {
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLACK = "\u001B[30m";

    String name;
    public int health,damage,armor,speed;
    public int attack,shots;
    int ammunition;
    public int mana,delivery;


    public Man(int x, int y, String name, int health, int damage, int armor, int speed, int attack, int shots, int ammunition, int mana, int delivery) {
        super(x, y);
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.armor = armor;
        this.speed = speed;
        this.attack = attack;
        this.shots = shots;
        this.ammunition = ammunition;
        this.mana = mana;
        this.delivery = delivery;

    }



    @Override
    public String getInfo(){return ANSI_GREEN+"Я крестьянин!"+ANSI_RESET;}

    @Override
    public void step(List<Man> team1, List<Man> team2, int x, int y) {

    }

    public int getSpeed() {
        return speed;
    }

    public int getShots(){
        return this.shots;
    }

    public int setShots(int shots) {
        return this.shots = shots;
    }

    public int getHealth() {
        return health;
    }

    public int setHealth(int health) {
        return this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public int setAttack(int attack) {
        return this.attack = attack;
    }

    public int getDelivery() {
        return delivery;
    }

    public int setDelivery(int delivery) {
        return this.delivery = delivery;
    }
}

