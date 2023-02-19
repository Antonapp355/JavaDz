package org.example.Units;

import java.util.Random;

public class Sniper extends Man{

    public Sniper(String name, int health, int damage, int armor, int ammunition, int accuracy) {
        super(name, health, damage, armor);
        super.ammunition = ammunition;
        super.accuracy = accuracy;
    }

    public Sniper() {
        super(String.valueOf(Names.values()[new Random().nextInt(0,Names.values().length-1)]), 4,1,2);
        this.ammunition = 2;
        this.accuracy = 4;
    }


    public String toString() {
        return "Sniper\t\t{" +
                ANSI_YELLOW+"Имя: '" + name + '\'' +ANSI_RESET+
                ANSI_RED+",\t\t Здоровье: " + health +ANSI_RESET+
                ANSI_PURPLE+", Урон: " + damage +ANSI_RESET+
                ANSI_BLUE+", Броня: " + armor +ANSI_RESET+
                ", Патроны: " + ammunition +
                ", Меткость: " + accuracy +
                '}';
    }

    @Override
    public String getInfo() {
        return ANSI_GREEN+"Я снайпер!"+ANSI_RESET;
    }
}
