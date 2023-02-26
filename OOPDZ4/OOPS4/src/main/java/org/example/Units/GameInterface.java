package org.example.Units;

import java.util.List;

public interface GameInterface {
    public void step(List<Man> team1,List<Man> team2,int x,int y);
    String getInfo();
}
