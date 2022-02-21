package com.interview.chuteAndLadder;


import java.util.Random;

/**
 * @author Bing ZHANG
 * @created 19/01/2022
 */

public class Spinner {

    private int number;

    public Spinner(int number) {
        this.number = number;
    }

    public int getSpinner() {
        Random random = new Random();
        return random.nextInt(number) + 1;
    }
}
