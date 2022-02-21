package com.interview.algorithm;


/**
 * @author Bing ZHANG
 * @created 09/01/2022
 */
public class RecursionQuickSort {

    public static void quickSort(int[] arr, int l, int r) {
        if(l < r) {
            swap(arr, l + (int)(Math.random())* (r - l + 1), r);
            int[] part = partition(arr, l, r);
            quickSort(arr, l, part[0] -1);
            quickSort(arr, part[1]+1, r);
        }
    }
    public static int[] partition(int[] arr, int l, int r) {
        int less = l -1;
        int more = r;
        while(l < more) {
            if(arr[l] < arr[r]) {
                swap (arr, ++less, l++);
            } else if(arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less+1, more};
    }

    public static void swap(int[] arr, int l, int r) {
        arr[l] = arr[l] ^ arr[r];
        arr[r] = arr[l] ^ arr[r];
        arr[l] = arr[l] ^ arr[r];
    }

    public static void main(String[] args) {
        int[] arr = {5,2,1,5,5,7,9,5,3,11,5};
        partition(arr, 0, arr.length -1);
        for(int i : arr){
            System.out.println(i);
        }

    }
}
