package org.example.Units;

import java.util.Random;

public class addUnits{
    Random rnd = new Random();

    public Man addUnits1(){
        if(rnd.nextInt(0,4)==1){
            return new Farmer();
        } else if (rnd.nextInt(0, 10) == 2) {
            return new Outlaw();
        } else if (rnd.nextInt(0, 10) == 3) {
            return new Sniper();
        }else return new Mag();
    }

    public Man addUnits2(){
        if(rnd.nextInt(0,4)==1){
            return new Farmer();
        } else if (rnd.nextInt(0, 10) == 2) {
            return new Spearman();
        } else if (rnd.nextInt(0, 10) == 3) {
            return new Crossbowman();
        }else return new Monk();
    }

}
