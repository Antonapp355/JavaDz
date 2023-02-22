package org.example.Units;

import java.util.Random;

public class Outlaw extends Man{

    public Outlaw(String name, int x, int y, int health, int damage, int armor, int speed, int attack, int shots, int ammunition, int mana, int delivery) {
        super(name, x, y, health, damage, armor, speed, attack, shots, ammunition, mana, delivery);
    }

    public Outlaw() {
        super(String.valueOf(Names.values()[new Random().nextInt(0,Names.values().length-1)]),0,0,10,new Random().nextInt(2,4),3,6,8,0,0,0,0);
    }


    public String toString() {
        return "Outlaw\t\t{" +
                ANSI_YELLOW+"Имя: '" + name + '\'' +ANSI_RESET+
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
    public String getInfo() {
        return ANSI_GREEN+"Я разбойник!"+ANSI_RESET;
    }
}
