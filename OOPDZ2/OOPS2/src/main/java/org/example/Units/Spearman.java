package org.example.Units;

import java.util.Random;

public class Spearman extends Man{
    public Spearman(String name, int health, int damage, int armor) {
        super(name, health, damage, armor);
    }

    public Spearman() {
        super(String.valueOf(Names.values()[new Random().nextInt(0,Names.values().length-1)]), 4, 4, 5);
    }


    public String toString() {
        return "Spearman\t{" +
                ANSI_YELLOW+"Имя: '" + name + '\'' +ANSI_RESET+
                ANSI_RED+",\t\t Здоровье: " + health +ANSI_RESET+
                ANSI_PURPLE+", Урон: " + damage +ANSI_RESET+
                ANSI_BLUE+", Броня: " + armor +ANSI_RESET+
                '}';
    }

    @Override
    public String getInfo() {
        return ANSI_GREEN+"Я копейщик!"+ANSI_RESET;
    }
}
