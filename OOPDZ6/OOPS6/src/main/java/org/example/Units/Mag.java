package org.example.Units;


import java.util.List;

public class Mag extends Magic{

    public Mag(String name, Vector2D coords) {
        super("Stand",
                30,
                coords.posX,
                coords.posY,
                name,
                30,
                -5,
                -5,
                12,
                9,
                17,
                0,
                1);
    }

    @Override
    public void step(List<Man> team1, List<Man> team2) {
        //Проверяем жив ли я
        if(state.equals("Die")){
            health = 0;
            return;
        }
        //Ищем самого ближайшего союзника
        for (int i = 0; i < team2.size(); i++) {
            if (team2.get(i).health<team2.get(i).maxHealth & !team2.get(i).state.equals("Die")){
                //Лечим
                team2.get(i).getDamage(damageMax);
            }else return;
        }
    }

    @Override
    public String getInfo() {
        return "Маг!";
    }
}
