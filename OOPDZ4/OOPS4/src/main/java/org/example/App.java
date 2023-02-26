package org.example;

import org.example.Units.*;

import java.util.*;

import static java.lang.Math.*;


public class App extends Man
{
    public App(int x, int y, String name, int health, int damage, int armor, int speed, int attack, int shots, int ammunition, int mana, int delivery) {
        super(x, y, name, health, damage, armor, speed, attack, shots, ammunition, mana, delivery);
    }

    public static void main(String[] args ) {

        List<Man> team1 = new ArrayList<>();
        List<Man> team2 = new ArrayList<>();

        //Заполнение списков рандомными персонажами.
        for (int i = 0; i < 10; i++) {
            team1.add(new addUnits().addUnits1());
            team2.add(new addUnits().addUnits2());
        }
        for (int i = 0; i < team2.size(); i++) {
            team1.get(i).setY(i);
            team1.get(i).setX(0);
            team2.get(i).setY(i);
            team2.get(i).setX(team2.size()-1);
        }

        //Сортировка списков по скорости.
        team1.sort(new Comparator<Man>() {
            @Override
            public int compare(Man o1, Man o2) {
                return o1.getSpeed()- o2.getSpeed();
            }
        });
        team2.sort(new Comparator<Man>() {
            @Override
            public int compare(Man o1, Man o2) {
                return o1.getSpeed()- o2.getSpeed();
            }
        });

        System.out.println(ANSI_CYAN+"\nКоманда 1."+ANSI_RESET);
        for (Man unit: team1) {
            System.out.println(unit+"\t\t"+unit.getInfo());
        }

        System.out.println(ANSI_CYAN+"\nКоманда 2."+ANSI_RESET);
        for (Man unit: team2) {
            System.out.println(unit+"\t\t"+unit.getInfo());
        }

        //Заполнение поля.
        for (int i = 0; i < team1.size(); i++) {
            pole[team1.get(i).getY()][team1.get(i).getX()] = team1.get(i);
            pole[team2.get(i).getY()][team2.get(i).getX()] = team2.get(i);
        }

        //Печать поля
        Vector2D.pole();
    }

}
