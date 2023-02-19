package org.example.Units;

import java.util.Random;

public class Monk extends Man {


    public Monk(String name, int health, int damage, int armor, int mana, int hill) {
        super(name, health, damage, armor);
        super.mana = mana;
        super.hill = hill;
    }

    public Monk() {
        super(String.valueOf(Names.values()[new Random().nextInt(0,Names.values().length-1)]), 4,1,2);
        this.mana = 5;
        this.hill = 3;
    }


    public String toString() {
        return "Monk\t\t{" +
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
        return ANSI_GREEN+"Я монах!"+ANSI_RESET;
    }
}
