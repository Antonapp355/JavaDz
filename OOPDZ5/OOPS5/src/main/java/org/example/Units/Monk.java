package org.example.Units;

import java.util.List;
import java.util.Random;

public class Monk extends Man {

    public Monk() {
        super("Stand",
                30,
                0,
                0,
                String.valueOf(Names.values()[new Random().nextInt(0,Names.values().length-1)]),
                30,
                -4,
                -4,
                7,
                5,
                12,
                0,
                0,
                1,
                0);
    }

    @Override
    public void step(List<Man> team1, List<Man> team2) {
        //Проверяем жив ли я
        if(state.equals("Die")) return;
        //Ищем самого ближайшего союзника
        for (int i = 0; i < team1.size(); i++) {
            if (team1.get(i).health<team1.get(i).maxHealth){
                //Лечим
                team1.get(i).getDamage(damageMax);
            }
        }
    }

    @Override
    public String getInfo() {
        return "Я монах!";
    }
}
