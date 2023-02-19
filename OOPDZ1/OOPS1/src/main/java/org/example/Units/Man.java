package org.example.Units;

public abstract class Man {
    //for All
    String name;
    int health,damage,armor;
    //for Сrossbowman and Sniper
    int ammunition,accuracy;
    //for Monk and Mag
    int mana,hill;

    public Man(String name, int health, int damage, int armor) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.armor = armor;
    }

}
