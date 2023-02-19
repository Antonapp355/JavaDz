package org.example.Units;

import java.util.Random;

public class Mag extends Monk{
    public Mag(String name, int health, int damage, int armor, int mana, int hill) {
        super(name, health, damage, armor, mana, hill);
    }

    public Mag() {
        super(String.valueOf(Names.values()[new Random().nextInt(0,Names.values().length-1)]), 3,2,3,5,2);
    }


    public String toString() {
        return "Mag\t\t\t{" +
                ANSI_YELLOW+"Имя: '" + name + '\'' +ANSI_RESET+
                ANSI_RED+",\t\t Здоровье: " + health +ANSI_RESET+
                ANSI_PURPLE+", Урон: " + damage +ANSI_RESET+
                ANSI_BLUE+", Броня: " + armor +ANSI_RESET+
                ", Мана: " + mana +
                ", Лечение: " + hill +
                '}';
    }

    @Override
    public String getInfo() {
        return ANSI_GREEN+"Я маг!"+ANSI_RESET;
    }
}
