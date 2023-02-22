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
    int x,y;
    int health,damage,armor,speed;
    int attack,shots;
    //for Crossbowman and Sniper
    int ammunition;
    //for Monk and Mag
    int mana,delivery;

    public Man(String name, int x, int y, int health, int damage, int armor, int speed, int attack, int shots, int ammunition, int mana, int delivery) {
        this.name = name;
        this.x = x;
        this.y = y;
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

    public Man() {
        this.name = String.valueOf(Names.values()[new Random().nextInt(0,Names.values().length-1)]);
        this.x = 0;
        this.y = 0;
        this.health = 1;
        this.damage = 1;
        this.armor = 1;
        this.speed = 3;
        this.attack = 1;
        this.delivery = 1;
    }


    public String toString() {
        return "Man\t\t\t{" +
                ANSI_YELLOW +"Имя: '" + name + '\'' +ANSI_RESET+
                ANSI_RED+",\t\t Здоровье: " + health +ANSI_RESET+
                ANSI_PURPLE+", Урон: " + damage +ANSI_RESET+
                ANSI_BLUE+", Броня: " + armor +ANSI_RESET+
                ", Скорость: " + speed +
                ", Атака: " + attack +
                ", Выстрелы: " + shots +
                ", Мана: " + mana +
                ", доставка: " + delivery +
                '}';
    }
    @Override
    public String getInfo(){return ANSI_GREEN+"Я крестьянин!"+ANSI_RESET;}

    @Override
    public int step(int a) {
        return a;
    }

    public int getSpeed() {
        return speed;
    }
}
