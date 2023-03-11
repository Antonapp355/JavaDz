package org.example.Units;

import java.util.*;

public class Crossbowman extends Shooter{

    public Crossbowman(String name, Vector2D coords) {
        super("Stand",
                10,
                coords.posX,
                coords.posY,
                name,
                10,
                2,
                3,
                3,
                4,
                6,
                0,
                16);
    }

    @Override
    public void step(List<Man> team1, List<Man> team2) {
        //Проверяем жив ли я
        if (state.equals("Die") || shots == 0) {
            health = 0;
            return;
        }
        //Ищем самого ближайшего противника
        int index = findNearest(team2);
        if (index == -1) return;
        //В повреждение будет записано damageMin еслизащита противника больше моей атаки если защита противника меньше моей атаки в повреждение запишется damageMax иначе запишется среднее повреждение
        //Это атака
        float damage = (team2.get(index).armor - attack > 0) ?
                damageMin : (team2.get(index).armor - attack < 0) ?
                damageMax : (damageMax / damageMin) / 2;
        team2.get(index).getDamage(damage);
        for (int i = 0; i < team2.size(); i++) {
            if (team1.get(i).getInfo().equals("Крестьянин") && team1.get(i).state.equals("Stand")) {
                team1.get(i).state = "Busy";
                return;
            }
        }
        shots--;
    }

    @Override
    public String getInfo() {
        return "Арбалетчик!";
    }
}
