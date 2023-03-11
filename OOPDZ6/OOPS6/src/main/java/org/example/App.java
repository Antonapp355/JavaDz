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

    public static List<Man> team1 = new ArrayList<>();
    public static List<Man> team2 = new ArrayList<>();
    public static List<Man> teams = new ArrayList<>();


    public static void main (String[] args ) {

        //Заполнение списков рандомными персонажами.
        for (int i = 0; i < 10; i++) {
            team1.add(addUnits1(0,i));
            team2.add(addUnits2(9,i));
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

        System.out.println(new String(Character.toChars(0x1F345)));


        System.out.println(ANSI_CYAN+"\nКоманда 1."+ANSI_RESET);
        for (Man unit: team1)
        {
            System.out.println(unit.toInfo()+"\t\t"+unit.getInfo());
        }

        System.out.println(ANSI_CYAN+"\nКоманда 2."+ANSI_RESET);
        for (Man unit: team2) {
            System.out.println(unit.toInfo()+"\t\t"+unit.getInfo());
        }

        //while для зацикливания степа
        Scanner user_input = new Scanner(System.in);
        while (true){
            View.view();
            user_input.nextLine();
            teams.forEach(n-> n.step(team1,team2));
        }

    }

    public static String toName(){
        return String.valueOf(Names.values()[new Random().nextInt(0,Names.values().length-1)]);
    }
    public static Man addUnits2(int posX, int posY){
        if(new Random().nextInt(0,4)==1){
            return new Farmer(toName(),new Vector2D(posX,posY));
        } else if (new Random().nextInt(0, 4) == 2) {
            return new Outlaw(toName(),new Vector2D(posX,posY));
        } else if (new Random().nextInt(0, 4) == 3) {
            return new Sniper(toName(),new Vector2D(posX,posY));
        }else return new Mag(toName(),new Vector2D(posX,posY));
    }
    public static Man addUnits1(int posX, int posY){
        if(new Random().nextInt(0,5)==1){
            return new Farmer(toName(),new Vector2D(posX,posY));
        } else if (new Random().nextInt(0, 5) == 2) {
            return new Spearman(toName(),new Vector2D(posX,posY));
        } else if (new Random().nextInt(0, 5) == 3) {
            return new Crossbowman(toName(),new Vector2D(posX,posY));
        }else return new Monk(toName(),new Vector2D(posX,posY));
    }



}
