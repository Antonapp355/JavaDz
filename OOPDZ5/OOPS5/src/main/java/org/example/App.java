package org.example;

import org.example.Units.*;

import java.util.*;


public class App
{
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLACK = "\u001B[30m";


    public static void main (String[] args ) {
        List<Man> teams = new ArrayList<>();

        List<Man> team1 = new ArrayList<>();
        List<Man> team2 = new ArrayList<>();

        //Заполнение списков рандомными персонажами.
        for (int i = 0; i < 10; i++) {
            team1.add(new addUnits().addUnits1());
            team2.add(new addUnits().addUnits2());
        }
        for (int i = 0; i < team1.size(); i++) {
            team1.get(i).setCoords(new Vector2D(0,i));
            team2.get(i).setCoords(new Vector2D(9,i));
        }

        for (int i = 0; i < team1.size(); i++) {
            teams.add(team1.get(i));
            teams.add(team2.get(i));
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
            System.out.println(unit.toInfo()+"\t\t"+unit.getInfo());
        }

        System.out.println(ANSI_CYAN+"\nКоманда 2."+ANSI_RESET);
        for (Man unit: team2) {
            System.out.println(unit.toInfo()+"\t\t"+unit.getInfo());
        }

        //while для зацикливания степа
        Scanner user_input = new Scanner(System.in);
        while (true){
            System.out.println(ANSI_RED + "\nПосле боя.\n" + ANSI_RESET);
            user_input.nextLine();
            teams.forEach(n-> n.step(team1,team2));
            System.out.println(ANSI_CYAN+"\nКоманда 1."+ANSI_RESET);
            for (Man unit: team1) {
                System.out.println(unit.toInfo()+"\t\t"+unit.getInfo());
            }

            System.out.println(ANSI_CYAN+"\nКоманда 2."+ANSI_RESET);
            for (Man unit: team2) {
                System.out.println(unit.toInfo()+"\t\t"+unit.getInfo());
            }
        }

    }



}
