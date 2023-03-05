package org.example.Units;

import java.util.List;
import java.util.Random;

public class Sniper extends Shooter{

    public Sniper() {
        super("Stand",
                15,
                0,
                0,
                String.valueOf(Names.values()[new Random().nextInt(0,Names.values().length-1)]),
                15,
                8,
                10,
                10,
                9,
                12,
                32);
    }

    @Override
    public void step(List<Man> team1, List<Man> team2) {
        //Проверяем жив ли я
        if (state.equals("Die") || shots == 0) return;
        //Ищем самого ближайшего противника
        int index = findNearest(team1);
        if (index == -1) return;
        //В повреждение будет записано damageMin еслизащита противника больше моей атаки если защита противника меньше моей атаки в повреждение запишется damageMax иначе запишется среднее повреждение
        //Это атака
        float damage = (team1.get(index).armor - attack > 0) ?
                damageMin : (team1.get(index).armor - attack < 0) ?
                damageMax : (damageMax / damageMin) / 2;
        team1.get(index).getDamage(damage);
        for (int i = 0; i < team2.size(); i++) {
            if (team2.get(i).getInfo().split(" ")[1].equals("крестьянин") && team2.get(i).state.equals("Stand")) {
                team2.get(i).state = "Busy";
                return;
            }
        }
        shots--;
    }

    @Override
    public String getInfo() {
        return "Я снайпер!";
    }
}
