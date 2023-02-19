package org.example.Units;

import java.util.Random;

public class Crossbowman extends Sniper{
    public Crossbowman() {
        super(String.valueOf(Names.values()[new Random().nextInt(0,Names.values().length-1)]), 2, 2, 2, 5, 3);
    }


    public String toString() {
        return "Crossbowman\t{" +
                ANSI_YELLOW+"Имя: '" + name + '\'' +ANSI_RESET+
                ANSI_RED+",\t\t Здоровье: " + health +ANSI_RESET+
                ANSI_PURPLE+", Урон: " + damage +ANSI_RESET+
                ANSI_BLUE+", Броня: " + armor +ANSI_RESET+
                ", Патроны: "+ ammunition +
                ", Меткость: "+ accuracy +
                '}';
    }

    @Override
    public String getInfo() {
        return ANSI_GREEN+"Я арбалетчик!"+ANSI_RESET;
    }

    @Override
    public void step(int a) {}
}
