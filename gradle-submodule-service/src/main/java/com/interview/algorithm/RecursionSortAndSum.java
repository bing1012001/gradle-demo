package com.interview.algorithm;

/**
 * @author Bing ZHANG
 * @created 09/01/2022
 */
public class RecursionSortAndSum {


    public static int smallSum(int[] arr, int l, int r) {
        if(arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length -1);
    }

    public static int process(int[] arr, int l, int r) {
        if(l == r) {
            return 0;
        }
        int mid = l + ((r - l )>> 1);
        return process(arr, l, mid) + process(arr, mid +1, r) + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        int result = 0;
        while(p1 <= mid && p2 <= r) {
            result += arr[p1] < arr[p2] ? (r-p2 +1)* arr[p1] : 0;
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while ((p2 <=r)) {
            temp[i++] = arr[p2++];
        }
        for(int j = 0; j< temp.length; j++) {
            arr[l + j] = temp[j];
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
