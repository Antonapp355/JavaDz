package org.example.Units;

public class Crossbowman extends Sniper{
    public Crossbowman(String name, int health, int damage, int armor, int ammunition, int accuracy)
    {super(name,health,damage,armor,ammunition,accuracy);}

    public Crossbowman() {
        super("Crossbowman", 2, 2, 2, 5, 3);
    }

    @Override
    public String toString() {
        return "Crossbowman{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                ", armor=" + armor +
                '}';
    }
}
