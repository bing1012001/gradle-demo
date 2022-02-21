package com.interview.algorithm;

/**
 * @author Bing ZHANG
 * @created 06/01/2022
 */
public class RecursionSort {

    public static void process(int[] arr, int l, int r) {
        if(l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        process(arr, l, mid);
        process( arr, mid +1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l +1];
        int i = 0;
        int p1 = l;
        int p2 = mid +1;
        while(p1 <= mid && p2 <= r) {
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while(p2 <= r) {
            temp[i++] = arr[p2++];
        }

        for(int j = 0; j < temp.length; j++) {
            arr[l + j] = temp[j];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,2,7,11,3,9,16,1};
        process(arr, 0, arr.length -1);
        for(int i: arr) {
            System.out.println(i);
        }
    }
}
