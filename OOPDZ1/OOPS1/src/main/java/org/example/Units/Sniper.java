package org.example.Units;

public class Sniper extends AllCharacter{
    int ammunition;
    int accuracy;

    public Sniper(String name, int health, int damage, int armor, int ammunition, int accuracy) {
        super(name, health, damage, armor);
        this.ammunition = ammunition;
        this.accuracy = accuracy;
    }
}
