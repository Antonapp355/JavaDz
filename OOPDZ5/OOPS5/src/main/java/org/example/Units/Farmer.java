package org.example.Units;

import java.util.List;
import java.util.Random;

public class Farmer extends Man {


    public Farmer(){
        super("Stand",
                1,
                0,
                0,
                String.valueOf(Names.values()[new Random().nextInt(0,Names.values().length-1)]),
                1,
                0,
                1,
                1,
                3,
                1,
                0,
                0,
                0,
                1);
    }

    @Override
    public void step(List<Man> team1, List<Man> team2) {
        if (!state.equals("Die")){
            state = "Stand";
        } else {
            health = 0;
        }
    }

    @Override
    public String getInfo() {
        return "Я крестьянин";
    }
}
