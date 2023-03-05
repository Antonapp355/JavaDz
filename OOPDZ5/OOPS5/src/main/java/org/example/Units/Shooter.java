package org.example.Units;

public abstract class Shooter extends Man{
    protected int shots;

    public Shooter(String state, int maxHealth, int posX, int posY, String name, int health, int damageMin, int damageMax, int armor, int speed, int attack, int shots) {
        super(state, maxHealth, posX, posY, name, health, damageMin, damageMax, armor, speed, attack);
        this.shots = shots;
    }
}
