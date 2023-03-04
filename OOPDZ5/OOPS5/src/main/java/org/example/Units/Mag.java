package org.example.Units;

import java.util.List;
import java.util.Random;

public class Mag extends Man{

    public Mag() {
        super("Stand",
                30,
                0,
                0,
                String.valueOf(Names.values()[new Random().nextInt(0,Names.values().length-1)]),
                30,
                -5,
                -5,
                12,
                9,
                17,
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
        for (int i = 0; i < team2.size(); i++) {
            if (team2.get(i).health<team2.get(i).maxHealth){
                //Лечим
                team2.get(i).getDamage(damageMax);
            }
        }
    }

    @Override
    public String getInfo() {
        return "Я маг!";
    }
}
