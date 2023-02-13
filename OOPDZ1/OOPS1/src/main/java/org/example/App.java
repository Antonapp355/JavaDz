package org.example;

import org.example.Units.*;


public class App
{
    public static void main( String[] args )
    {
        Farmer farmer = new Farmer("Farmer", 1, 1, 0);
        Outlaw outlaw = new Outlaw("Outlaw", 2, 2, 1,1);
        Sniper sniper = new Sniper("Sniper", 2, 4, 1, 5,5);
        Mag mag = new Mag("Mag", 2,2,1,5,1);
        Spearman spearman = new Spearman("Spearman", 4,3,3);
        Сrossbowman сrossbowman = new Сrossbowman("Crossbowman",3,3,2,5,3);
        Monk monk = new Monk("Monk", 2, 1,1,5,3);
    }
}
