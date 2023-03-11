package org.example.Units;

import java.util.List;

public abstract class Shooter extends Man{
    protected int shots;

    public Shooter(String state, int maxHealth, int posX, int posY, String name, int health, int damageMin, int damageMax, int armor, int speed, int attack, int delivery, int shots) {
        super(state, maxHealth, posX, posY, name, health, damageMin, damageMax, armor, speed, attack, delivery);
        this.shots = shots;
    }
}
