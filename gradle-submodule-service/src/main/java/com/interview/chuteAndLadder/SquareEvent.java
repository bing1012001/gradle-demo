package com.interview.chuteAndLadder;

import java.util.Random;
import java.util.Set;

/**
 * @author Bing ZHANG
 * @created 19/01/2022
 */
public class SquareEvent {
    private int fromSpot;
    private int toSpot;
    private String name;

    public SquareEvent(String name, int max, Set<Integer> fromSet) {
        this.name = name;
        fromSpot = new Random().nextInt(max) + 1;
        toSpot = new Random().nextInt(max) + 1;
        if("CHUTE".equals(name)) {
            while(fromSet.contains(fromSpot) || ((fromSpot-1) / 10) == 0 || fromSpot == 100) {
                fromSpot = new Random().nextInt(max) + 1;
            }
            while(((fromSpot -1 )/ 10) == ((toSpot -1)/ 10) || toSpot > fromSpot) {
                toSpot = new Random().nextInt(max) + 1;
            }

        } else {
            while(fromSet.contains(fromSpot) || ((fromSpot-1) / 10) == 9 || fromSpot == 100) {
                fromSpot = new Random().nextInt(max) + 1;
            }
            while(((fromSpot -1 ) / 10) == ((toSpot -1) / 10) || toSpot < fromSpot) {
                toSpot = new Random().nextInt(max) + 1;
            }
        }
        fromSet.add(fromSpot);
    }

    public int getFromSpot() {
        return fromSpot;
    }

    public int getToSpot()  {
        return toSpot;
    }

    public String getName() {
        return name;
    }
}
