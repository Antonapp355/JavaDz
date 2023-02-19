package org.example.Units;

import java.util.Random;

public class Outlaw extends Man{

    public Outlaw(String name, int health, int damage, int armor) {
        super(name, health, damage, armor);
    }

    public Outlaw() {
        super(String.valueOf(Names.values()[new Random().nextInt(0,Names.values().length-1)]), 2, 2, 2);
    }


    public String toString() {
        return "Outlaw\t\t{" +
                ANSI_YELLOW+"Имя: '" + name + '\'' +ANSI_RESET+
                ANSI_RED+",\t\t Здоровье: " + health +ANSI_RESET+
                ANSI_PURPLE+", Урон: " + damage +ANSI_RESET+
                ANSI_BLUE+", Броня: " + armor +ANSI_RESET+
                '}';
    }

    @Override
    public String getInfo() {
        return ANSI_GREEN+"Я разбойник!"+ANSI_RESET;
    }
}
