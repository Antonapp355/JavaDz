package org.example.Units;

import java.util.List;
import java.util.Random;

public class Spearman extends Man{

    public Spearman() {
        super("Stand",
                10,
                0,
                0,
                String.valueOf(Names.values()[new Random().nextInt(0,Names.values().length-1)]),
                10,
                1,
                3,
                5,
                4,
                4,
                0,
                0,
                0,
                0);
    }

    @Override
    public void step(List<Man> team1, List<Man> team2) {
        super.step(team1, team2);
    }

    @Override
    public String getInfo() {
        return "Я копейщик!";
    }
}
