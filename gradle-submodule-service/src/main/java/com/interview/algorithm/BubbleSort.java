package com.interview.algorithm;

/**
 * @author Bing ZHANG
 * @created 04/01/2022
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        for(int i = arr.length -1; i> 0; i--) {
            for(int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }
    public static void bubbleSort2(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        for(int i = 0; i < arr.length-1; i++) {
            for(int j = i+1; j< arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
    public static void main(String[] args) {
        int[] arr1 = {5,2,16,6,3,7};
        bubbleSort(arr1);
        int[] arr2 = {5,2,16,6,3,7};
        bubbleSort2(arr2);
        for(int i = 0; i <arr1.length; i++ ) {
            System.out.println(arr1[i]);
        }
        for(int i = 0; i <arr2.length; i++ ) {
            System.out.println(arr2[i]);
        }
    }
}
