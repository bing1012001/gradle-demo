package com.interview.chuteAndLadder;

/**
 * @author Bing ZHANG
 * @created 19/01/2022
 */
public class Square {
    private int value;
    private SquareEvent event;

    public Square(int value) {
        this.value = value;
    }

    public void setSquareEvent(SquareEvent event) {
        this.event = event;
    }

    public SquareEvent getSquareEvent() {
        return event;
    }


}
