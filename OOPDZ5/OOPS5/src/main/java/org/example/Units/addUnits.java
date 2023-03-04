package org.example.Units;

import java.util.Random;

public class addUnits{


    public Man addUnits2(){
        if(new Random().nextInt(0,4)==1){
            return new Farmer();
        } else if (new Random().nextInt(0, 10) == 2) {
            return new Outlaw();
        } else if (new Random().nextInt(0, 10) == 3) {
            return new Sniper();
        }else return new Mag();
    }

    public String toName(){
        return String.valueOf(Names.values()[new Random().nextInt(0,Names.values().length-1)]);
    }

    public Man addUnits1(){
        if(new Random().nextInt(0,4)==1){
            return new Farmer();
        } else if (new Random().nextInt(0, 10) == 2) {
            return new Spearman();
        } else if (new Random().nextInt(0, 10) == 3) {
            return new Crossbowman();
        }else return new Monk();
    }

}
