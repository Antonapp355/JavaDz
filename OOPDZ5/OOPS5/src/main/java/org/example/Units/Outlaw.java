package org.example.Units;

import java.util.List;
import java.util.Random;

public class Outlaw extends Man{


    public Outlaw() {
        super("Stand",
                10,
                0,
                0,
                String.valueOf(Names.values()[new Random().nextInt(0,Names.values().length-1)]),
                10,
                2,
                4,
                3,
                6);
    }

    @Override
    public void step(List<Man> team1, List<Man> team2) {
        super.step(team1, team2);
    }

    @Override
    public String getInfo() {
        return "Я разбойник!";
    }
}
