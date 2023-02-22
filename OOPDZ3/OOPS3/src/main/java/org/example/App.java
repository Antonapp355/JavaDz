package org.example;

import org.example.Units.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


public class App extends Man
{
    public static void main( String[] args ) {

        List<Man> lstUnitsWhite = new ArrayList<>();
        List<Man> lstUnitsBlack = new ArrayList<>();

        List<Man> lstUnits1 = new ArrayList<>();
        List<Man> lstUnits2 = new ArrayList<>();

        lstUnits1.add(new Man() {
            @Override
            public String toString() {
                return super.toString();
            }
        });
        lstUnits2.add(new Man() {
            @Override
            public String toString() {
                return super.toString();
            }
        });
        lstUnits2.add(new Crossbowman());
        lstUnits2.add(new Spearman());
        lstUnits1.add(new Outlaw());
        lstUnits1.add(new Mag());
        lstUnits2.add(new Monk());
        lstUnits1.add(new Sniper());

        //Заполнение списков рандомными персонажами.
        for (int i = 0; i < 10; i++) {
            lstUnitsWhite.add(lstUnits1.get(new Random().nextInt(0, lstUnits1.size())));
            lstUnitsBlack.add(lstUnits2.get(new Random().nextInt(0, lstUnits2.size())));
        }

        //Сортировка списков по скорости.
        lstUnitsWhite.sort(new Comparator<Man>() {
            @Override
            public int compare(Man o1, Man o2) {
                return o1.getSpeed()- o2.getSpeed();
            }
        });
        lstUnitsBlack.sort(new Comparator<Man>() {
            @Override
            public int compare(Man o1, Man o2) {
                return o1.getSpeed()- o2.getSpeed();
            }
        });

        System.out.println(ANSI_CYAN+"\nСписок белых."+ANSI_RESET);
        for (Man unit: lstUnitsWhite) {
            System.out.println(unit+"\t\t"+unit.getInfo());
        }

        System.out.println(ANSI_CYAN+"\nСписок черных."+ANSI_RESET);
        for (Man unit: lstUnitsBlack) {
            System.out.println(unit+"\t\t"+unit.getInfo());
        }
    }

}
