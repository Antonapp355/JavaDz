package org.example.Units;

import java.util.List;

public abstract class Vector2D {
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLACK = "\u001B[30m";
    int x,y;
    public static Man[][] pole = new Man[10][10];

    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Vector2D(){
        this.x = 0;
        this.y = 0;
    }
    public static void pole(){
        for (int i = 0; i < pole.length; i++) {
            System.out.println();
            for (int j = 0; j < pole.length; j++) {
                if (pole[i][j]!=null) {
                    if (pole[i][j].getClass() == Farmer.class) {
                        System.out.printf(ANSI_BLACK + "F\t" + ANSI_RESET);
                    } else if (pole[i][j].getClass() == Monk.class) {
                        System.out.printf(ANSI_GREEN + "M\t" + ANSI_RESET);
                    } else if (pole[i][j].getClass() == Mag.class) {
                        System.out.printf(ANSI_PURPLE + "M\t" + ANSI_RESET);
                    } else if (pole[i][j].getClass() == Sniper.class) {
                        System.out.printf(ANSI_YELLOW + "S\t" + ANSI_RESET);
                    } else if (pole[i][j].getClass() == Spearman.class) {
                        System.out.printf(ANSI_RED + "S\t" + ANSI_RESET);
                    } else if (pole[i][j].getClass() == Crossbowman.class) {
                        System.out.printf(ANSI_CYAN + "C\t" + ANSI_RESET);
                    } else if (pole[i][j].getClass() == Outlaw.class) {
                        System.out.printf(ANSI_BLUE + "O\t" + ANSI_RESET);
                    }
                } else if (pole[i][j] == null) {
                    System.out.printf("\t#\t");
                }
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int setX(int x) {
        return this.x = x;
    }

    public int setY(int y) {
        return this.y = y;
    }

//    public List<Man> searchCoord(List<Man> t, int y){
//        for (int i = 0; i < 10; i++) {
//
//        }
//        return
//    }
}
