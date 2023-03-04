package org.example.Units;

import java.util.List;

public interface GameInterface {
    void step(List<Man> team1, List<Man> team2);
    String getInfo();
}
