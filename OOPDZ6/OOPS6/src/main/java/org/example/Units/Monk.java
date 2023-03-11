package org.example.Units;

import java.util.List;
import java.util.Random;

public class Monk extends Magic {
    public Monk(String name, Vector2D coords) {
        super("Stand",
                30,
                coords.posX,
                coords.posY,
                name,
                30,
                -4,
                -4,
                7,
                5,
                12,
                0,
                1);
    }

    @Override
    public void step(List<Man> team1, List<Man> team2) {
        //Проверяем жив ли я
        if(state.equals("Die")) {
            health = 0;
            return;
        }
        //Ищем самого ближайшего союзника
        for (int i = 0; i < team1.size(); i++) {
            if (team1.get(i).health<team1.get(i).maxHealth & !team1.get(i).state.equals("Die")){
                //Лечим
                team1.get(i).getDamage(damageMax);
            }else return;
        }
    }
    @Override
    public String getInfo() {
        return "Монах!";
    }
}
