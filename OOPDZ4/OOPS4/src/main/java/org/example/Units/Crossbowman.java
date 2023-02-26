package org.example.Units;

import java.util.*;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Crossbowman extends Man{

    public Crossbowman(int x, int y, String name, int health, int damage, int armor, int speed, int attack, int shots, int ammunition, int mana, int delivery) {
        super(x, y, name, health, damage, armor, speed, attack, shots, ammunition, mana, delivery);
    }

    public Crossbowman() {
        super(0,0,String.valueOf(Names.values()[new Random().nextInt(0,Names.values().length-1)]),10,new Random().nextInt(2,3),3,4,6,16,0,0,0);
    }

    public String toString() {
        return "Crossbowman\t{" +
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
    public void step(List<Man> team1, List<Man> team2,int x,int y) {
        int indexCross = 0;
        //Поиск текущего арбалетчика в команде.
        for (int i = 0; i < team1.size(); i++) {
            //Если в команде есть арбалетчик и координаты совпадают
            if ((team1.get(i).getClass() == Crossbowman.class) && (team1.get(i).getX()==x) && (team1.get(i).getY()==y)){
                //Запоминаем индекс арбалетчика
                indexCross = i;
                if ((team1.get(indexCross).getHealth()<1) && (team1.get(indexCross).getShots()<1)){
                    return;
                }
            }
        }
        //Создаю список расстояний до противников
        List<Double> list = new ArrayList<>();
        //Поиск всех расстояний до противников
        for (int i = 0; i < team2.size(); i++) {
            list.add(sqrt(pow((team2.get(i).getX()-team1.get(indexCross).getX()),2)+pow((team2.get(i).getY()-team1.get(indexCross).getY()),2)));
        }
        //Если у элемента под индексом минимального элемента health > 0
        if (team2.get(list.indexOf(Collections.min(list))).getHealth() > 0){
            //Нужно атаковать
            //У вражеского юнита под индексом минимального значения вычитаются health в размере attack
            team2.get(list.indexOf(Collections.min(list))).setHealth(getHealth()-team1.get(indexCross).getAttack());
            //Ищем крестьянина
            boolean search = false;
            for (int i = 0; i < team2.size(); i++) {
                //Если это крестьянин и здоровье выше нуля
                if ((team1.get(i).getClass() == Farmer.class) && (team1.get(i).getDelivery()>0) && (team1.get(i).getHealth()>0)){
                    search = true;
                }
            }
            //Если крестьянин не найден
            if (search==false){
                //У арбалетчика вычитается стрела
                team1.get(indexCross).setShots(-1);
                System.out.println("Крестьян нет в живых. ");
            }else {
                return;
            }
        }
    }
    @Override
    public String getInfo() {
        return ANSI_GREEN+"Я арбалетчик!"+ANSI_RESET;
    }

}
