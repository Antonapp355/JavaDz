package org.example.Units;

import java.util.Random;

public class Monk extends Man {


    public Monk(String name, int x, int y, int health, int damage, int armor, int speed, int attack, int shots, int ammunition, int mana, int delivery) {
        super(name, x, y, health, damage, armor, speed, attack, shots, ammunition, mana, delivery);
    }

    public Monk() {
        super(String.valueOf(Names.values()[new Random().nextInt(0,Names.values().length-1)]),0,0,30,-4,7,5,12,0,0,1,0);
        this.mana = 1;
    }


    public String toString() {
        return "Monk\t\t{" +
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
        return ANSI_GREEN+"Я монах!"+ANSI_RESET;
    }
}
