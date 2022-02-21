package com.interview.algorithm;

/**
 * @author Bing ZHANG
 * @created 04/01/2022
 */
public class MathCalc {

    public static void calc(int[] arr) {
        int eor = 0;
        for(int i: arr) {
            eor ^= i;
        }
        int rightOne = eor & (~eor +1);
        int onlyOne = 0;
        for (int i:arr) {
            if((i & rightOne) == 0) {
                onlyOne ^= i;
            }
        }

        System.out.print(onlyOne + " " + (eor ^ onlyOne));
    }
    public static void main(String[] args) {
        calc(new int[]{3,3,3,2,2,2,2,6,6,6,6,6,1,9,9,9,9,15,15,21});
    }
}
