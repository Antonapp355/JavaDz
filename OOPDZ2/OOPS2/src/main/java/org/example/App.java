package org.example;

import org.example.Units.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class App extends Man
{
    public static void main( String[] args ) {

        List<Man> lstUnits = new ArrayList<>();
        List<Man> lstRandom = new ArrayList<>();
        lstUnits.add(new Man() {
            @Override
            public String toString() {
                return super.toString();
            }
        });
        lstUnits.add(new Crossbowman());
        lstUnits.add(new Spearman());
        lstUnits.add(new Outlaw());
        lstUnits.add(new Mag());
        lstUnits.add(new Monk());
        lstUnits.add(new Sniper());

        for (int i = 0; i < 10; i++) {
            lstRandom.add(lstUnits.get(new Random().nextInt(0, lstUnits.size())));
        }

        System.out.println(ANSI_CYAN+"\nСписок рандомных персонажей."+ANSI_RESET);
        for (Man unit: lstRandom) {
            System.out.println(unit+"\t\t"+unit.getInfo());
        }
        System.out.println(ANSI_CYAN+"\nСписок всех персонажей."+ANSI_RESET);
        for (Man unit: lstUnits) {
            System.out.println(unit+"\t\t"+unit.getInfo());
        }
    }

}
