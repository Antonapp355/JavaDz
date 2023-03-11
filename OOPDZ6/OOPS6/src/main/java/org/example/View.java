package org.example;

import org.example.Units.Vector2D;
import org.example.Units.Man;

import java.util.Collections;

public class View {
    private static int step = 1;
    private static final int[] l = {0};
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b"))) + formatDiv("-c");
    private static final String midl10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h"))) + formatDiv("-i");
    private static void tabSetter(int cnt, int max){
        int dif = max - cnt + 2;
        if (dif>0) System.out.printf("%" + dif + "s", ":"); else System.out.print(":");
    }
    private static String formatDiv(String str) {
        return str.replace('a', '\u250c')   //       ┌─┬─┐
                .replace('b', '\u252c')     //       |M|K|
                .replace('c', '\u2510')     //       ├─┼─┤
                .replace('d', '\u251c')     //       |S|O|
                .replace('e', '\u253c')     //       └─┴─┘
                .replace('f', '\u2524')     //
                .replace('g', '\u2514')     //
                .replace('h', '\u2534')     //
                .replace('i', '\u2518')     //
                .replace('-', '\u2500');    //
    }
    private static String getChar(int x, int y){
        String out = "| ";
        for (Man human: App.teams) {
            if (human.getCoords()[0] == x && human.getCoords()[1] == y){
                if (human.getHp() == 0) {
                    out = "|" + (AnsiColors.ANSI_RED + human.getInfo().charAt(0) + AnsiColors.ANSI_RESET);
                    break;
                }
                if (App.team1.contains(human)) out = "|" + (AnsiColors.ANSI_GREEN + human.getInfo().charAt(0) + AnsiColors.ANSI_RESET);
                if (App.team2.contains(human)) out = "|" + (AnsiColors.ANSI_BLUE + human.getInfo().charAt(0) + AnsiColors.ANSI_RESET);
                break;
            }
        }
        return out;
    }
    public static void view() {
        if (step == 1 ){
            System.out.print(AnsiColors.ANSI_RED + "First step" + AnsiColors.ANSI_RESET);
        } else {
            System.out.print(AnsiColors.ANSI_RED + "Step:" + step + AnsiColors.ANSI_RESET);
        }
        step++;

        //Поиск самой длинной строки для табсеттера
        App.teams.forEach((v) -> l[0] = Math.max(l[0], v.toInfo().length()));

        //Создание -------- строки
        for (int i = 0; i < l[0]*2; i++) System.out.print("_");
        System.out.println("");

        //Создание top10 и цвета команд ┌─┬─┬─┬─┬─┬─┬─┬─┬─┬─┐
        System.out.print(top10 + "    ");
        System.out.print(AnsiColors.ANSI_GREEN+"Green side"+AnsiColors.ANSI_RESET);
        for (int i = 0; i < l[0]-9; i++) System.out.print(" ");
        System.out.println(":"+AnsiColors.ANSI_BLUE+"Blue side"+AnsiColors.ANSI_RESET);

        //Создание боковин с персонажем |М|М|М|М|М|М|М|М|М|К|
        for (int i = 0; i < 10; i++) {
            System.out.print(getChar(0, i));
        }
        System.out.print("|    ");

        //Создание первой строки персонажей справа от поля
        System.out.print(App.team1.get(0).toInfo());
        tabSetter(App.team1.get(0).toInfo().length(), l[0]);
        System.out.println(App.team2.get(0).toInfo());

        //Создание midl10 ├─┼─┼─┼─┼─┼─┼─┼─┼─┼─┤
        System.out.println(midl10);

        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(getChar(i, j));
            }
            System.out.print("|    ");
            System.out.print(App.team1.get(i).toInfo());
            tabSetter(App.team1.get(i).toInfo().length(), l[0]);
            System.out.println(App.team2.get(i).toInfo());
            if (i != 9)System.out.println(midl10);
        }
        System.out.println(bottom10);


    }
}
