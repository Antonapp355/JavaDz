package org.example.Units;

import java.util.Random;

public abstract class Man implements GameInterface {
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_GREEN = "\u001B[32m";

    //for All
    String name;
    int health,damage,armor;
    //for Crossbowman and Sniper
    int ammunition,accuracy;
    //for Monk and Mag
    int mana,hill;

    public Man(String name, int health, int damage, int armor) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.armor = armor;
    }

    public Man() {
        this.name = String.valueOf(Names.values()[new Random().nextInt(0,Names.values().length-1)]);;
        this.health = 1;
        this.damage = 1;
        this.armor = 1;
    }


    public String toString() {
        return "Man\t\t\t{" +
                ANSI_YELLOW +"Имя: '" + name + '\'' +ANSI_RESET+
                ANSI_RED+",\t\t Здоровье: " + health +ANSI_RESET+
                ANSI_PURPLE+", Урон: " + damage +ANSI_RESET+
                ANSI_BLUE+", Броня: " + armor +ANSI_RESET+
                '}';
    }
    @Override
    public void step(int a){}
    @Override
    public String getInfo(){return ANSI_GREEN+"Я человек!"+ANSI_RESET;}

}
