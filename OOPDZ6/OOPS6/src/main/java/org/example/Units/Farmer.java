package org.example.Units;

import java.util.List;

public class Farmer extends Man {
    public Farmer(String state, int maxHealth, int posX, int posY, String name, int health, int damageMin, int damageMax, int armor, int speed, int attack, int delivery) {
        super(state, maxHealth, posX, posY, name, health, damageMin, damageMax, armor, speed, attack, delivery);
    }

    public Farmer(String name, Vector2D coords) {
        super("Stand",
                1,
                coords.posX,
                coords.posY,
                name,
                1,
                1,
                1,
                1,
                3,
                1,
                1);
    }

    @Override
    public void step(List<Man> team1, List<Man> team2) {
        if (!state.equals("Die")){
            state = "Stand";
        } else if (health <= 0){
            health = 0;
        }
    }

    @Override
    public String getInfo() {
        return "Крестьянин";
    }
}
