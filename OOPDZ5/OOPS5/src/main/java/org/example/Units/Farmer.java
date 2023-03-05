package org.example.Units;

import java.util.List;
import java.util.Random;

public class Farmer extends Man {
    protected int delivery;

    public Farmer(String state, int maxHealth, int posX, int posY, String name, int health, int damageMin, int damageMax, int armor, int speed, int attack, int delivery) {
        super(state, maxHealth, posX, posY, name, health, damageMin, damageMax, armor, speed, attack);
        this.delivery = delivery;
    }

    public Farmer() {
        super("Stand",
                1,
                0,
                0,
                String.valueOf(Names.values()[new Random().nextInt(0,Names.values().length-1)]),
                1,
                1,
                1,
                1,
                3,
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
