package com.interview.algorithm;

/**
 * @author Bing ZHANG
 * @created 07/01/2022
 */
public class RecursionBinarySearch {

    public static int process(int arr[], int l, int r, int key) {
        if(l == r) {
            return -1;
        }
        int mid = l +((r-l) >> 1);
        if(key > arr[mid]) {
            return process(arr, mid +1, r, key);
        } else if(key < arr[mid]) {
            return process(arr, l, mid, key);
        } else {
            return mid;
        }

    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,6,7,8,9,11,12,13};
        int result = process(arr, 0, arr.length-1, 6);
        System.out.print(result);
    }

}
