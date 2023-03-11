package org.example.Units;

import java.util.List;

public class Spearman extends Man{

    //team1
    //Начинает с лева
    public Spearman(String name, Vector2D coords) {
        super("Stand",
                10,
                coords.posX,
                coords.posY,
                name,
                10,
                1,
                3,
                5,
                4,
                4,
                0);
    }

    @Override
    public void step(List<Man> team1, List<Man> team2) {
        if (state.equals("Die")) {
            health = 0;
            return;
        }
        int index = findNearest(team1);
        Man enemy = team2.get(index);
        if (coords.getDistance(enemy.coords) < 2d){
            float damage = (team2.get(index).armor - attack > 0) ?
                    damageMin : (team2.get(index).armor - attack < 0) ?
                    damageMax : (damageMax / damageMin) / 2;
            team2.get(index).getDamage(damage);
            return;
        }

//        //Если противник выше
//        if (enemy.coords.posY > coords.posY){
//            for (int i = 0; i < team2.size(); i++) {
//                if ((team2.get(i).coords.posY != coords.posY+1 & team2.get(i).coords.posX == coords.posX)
//                        |(team2.get(i).coords.posY != coords.posY+1 & team2.get(i).coords.posX != coords.posX)){
//                    stepUp();
//                }else {
//                    stepRight();
//                }
//            }
//        }

        //Догнал ли я противника по posY
        //Если posY(противник) меньше posY(мой) (противник ниже?)
        if (coords.getDown(enemy.coords)){
            //Если противник гдето ниже и клетка под мной пустая
            if (coords.getEmpty(team2,coords.posX,coords.posY-1)& coords.getEmpty(team1,coords.posX,coords.posY-1)){
                //Делаем шаг вниз
                stepDown();
                //Иначе шагаем вперёд
            } else {
                sideStep(team2,enemy);
            }
        //Если posY(противник) больше posY(мой)
        }else {
            //Если противник гдето выше и клетка над мной пустая
            if (coords.getEmpty(team2,coords.posX,coords.posY+1)& coords.getEmpty(team1,coords.posX,coords.posY+1)){
                //Делаем шаг вверх
                stepUp();
            }
            //Иначе шагаем вперёд
            else{
                sideStep(team2,enemy);
            }
        }

    }

    //Шаги в разные стороны.
    private void stepDown() { coords.posY -= 1; }
    private void stepUp()   { coords.posY += 1; }
    private void stepRight(){ coords.posX += 1; }

    protected void sideStep(List<Man> team, Man enemy){
        //Догнал ли я противника по posX
        //Если posX(противник) меньше posX(мой)
        if (coords.getLeft(enemy.coords)){
//            //Если в команде противников ни кто не стоит с лева
//            if (coords.getEmpty(team,coords.posX -1,coords.posY)) stepLeft();//Делаем шаг в лево
        }else {
            //Если в команде противников ни кто не стоит с права
            if (coords.getEmpty(team,coords.posX +1,coords.posY)) stepRight();//Делаем шаг в право
        }
    }

    @Override
    public String getInfo() {
        return "Копейщик!";
    }
}
