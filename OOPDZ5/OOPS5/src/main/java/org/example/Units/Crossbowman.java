package org.example.Units;

import java.util.*;

public class Crossbowman extends Man{

    public Crossbowman() {
        super("Stand",
                10,
                0,
                0,
                String.valueOf(Names.values()[new Random().nextInt(0,Names.values().length-1)]),
                10,
                2,
                3,
                3,
                4,
                6,
                16,
                0,
                0,
                0);
    }

    @Override
    public void step(List<Man> team1, List<Man> team2) {
        //Проверяем жив ли я
        if(state.equals("Die") || shots == 0) return;
        //Ищем самого ближайшего противника
        int index = findNearest(team2);
        //В повреждение будет записано damageMin еслизащита противника больше моей атаки если защита противника меньше моей атаки в повреждение запишется damageMax иначе запишется среднее повреждение
        //Это атака
        float damage = (team2.get(index).armor-attack > 0) ?
                damageMin : (team2.get(index).armor - attack < 0) ?
                damageMax : (damageMax+damageMin)/2;
        team2.get(index).getDamage(damage);
        for (int i = 0; i < team1.size(); i++) {
            if(team1.get(i).getInfo().split(" ")[1].equals("крестьянин") && team1.get(i).state.equals("Stand")) {
                team1.get(i).state = "Busy";
                return;
            }
        }
        shots--;
//        //Надо устроить проверку жив ли ктонибудь из врагов
//        //Нужен поиск крестьянина и взаимодействие с ним
//        boolean search = true;
//        if(team2!=null) {
//            //Он будет обращаться по координатам из мейна сам себя определит
//            int index = super.findNearest(team2); //Индекс ближайшего врага
//            //Если враг жив
//            if (team2.get(index).health > 0) {
//                //Если выстрелы есть
//                if (this.shots > 0) {
//                    //Если у врага есть броня или броня на нуле
//                    if (team2.get(index).armor > 0 || team2.get(index).armor == 0) {
//                        //Делаем выстрел в броню
//                        team2.get(index).armor = team2.get(index).armor - damage;
//                        //Если брон после выстрела меньше нуля
//                        if (team2.get(index).armor < 0) {
//                            //Прибавляем броню к здоровью (тем самым вычитаем здоровье учитывая атаку)
//                            team2.get(index).health += team2.get(index).armor;
//                            //Приравниваю броню нулю
//                            team2.get(index).armor = 0;
//                            for (int i = 0; i < team1.size(); i++) {
//                                if (team1.get(i).getClass() == Farmer.class && team1.get(i).health > 0){
//                                    return;
//                                } else if (team1.get(i).getClass() == Farmer.class && team1.get(i).health == 0) {
//                                    search = false;
//                                }
//                            }
//                            if (search==false){
//                                this.shots --;
//                            }
//                        } else {
//                            return;
//                        }
//                    } else {
//                        return;
//                    }
//                } else {
//                    return;
//                }
//            } else {
//                team2.get(index).health = 0;
//                step(team1, team2);
//            }
//        }
    }
    @Override
    public String getInfo() {
        return "Я арбалетчик!";
    }
}
