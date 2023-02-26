package org.example.Units;

import java.util.Random;

public class Mag extends Monk{
    public Mag(int x, int y, String name, int health, int damage, int armor, int speed, int attack, int shots, int ammunition, int mana, int delivery) {
        super(x, y, name, health, damage, armor, speed, attack, shots, ammunition, mana, delivery);
    }

    public Mag() {
        super(0,0,String.valueOf(Names.values()[new Random().nextInt(0,Names.values().length-1)]),30,-5,12,9,17,0,0,1,0);
    }


    public String toString() {
        return "Mag\t\t\t{" +
                "X: '" + x + '\'' +
                ", Y: '" + y + '\'' +
                ANSI_YELLOW+", Имя: '" + name + '\'' +ANSI_RESET+
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
        return ANSI_GREEN+"Я маг!"+ANSI_RESET;
    }
}
