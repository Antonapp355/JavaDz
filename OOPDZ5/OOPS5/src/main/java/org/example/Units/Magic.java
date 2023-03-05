package org.example.Units;

public abstract class Magic extends Man {
    protected int mana;

    public Magic(String state, int maxHealth, int posX, int posY, String name, int health, int damageMin, int damageMax, int armor, int speed, int attack, int mana) {
        super(state, maxHealth, posX, posY, name, health, damageMin, damageMax, armor, speed, attack);
        this.mana = mana;
    }
}
