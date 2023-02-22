package org.example.Units;

import java.util.Random;

public class Spearman extends Man{
    public Spearman(String name, int x, int y, int health, int damage, int armor, int speed, int attack, int shots, int ammunition, int mana, int delivery) {
        super(name, x, y, health, damage, armor, speed, attack, shots, ammunition, mana, delivery);
    }

    public Spearman() {
        super(String.valueOf(Names.values()[new Random().nextInt(0,Names.values().length-1)]),0,0,10,new Random().nextInt(1,3),5,4,4,0,0,0,0);
    }


    public String toString() {
        return "Spearman\t{" +
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
        return ANSI_GREEN+"Я копейщик!"+ANSI_RESET;
    }
}
