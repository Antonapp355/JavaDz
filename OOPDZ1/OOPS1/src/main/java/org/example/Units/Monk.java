package org.example.Units;

public class Monk extends AllCharacter {

    int mana;
    int hill;

    public Monk(String name, int health, int damage, int armor, int mana, int hill) {
        super(name, health, damage, armor);
        this.mana = mana;
        this.hill = hill;
    }
}
