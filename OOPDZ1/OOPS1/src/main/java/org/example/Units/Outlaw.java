package org.example.Units;

public class Outlaw extends AllCharacter{
    int trick;

    public Outlaw(String name, int health, int damage, int armor, int trick) {
        super(name, health, damage, armor);
        this.trick = trick;
    }
}
