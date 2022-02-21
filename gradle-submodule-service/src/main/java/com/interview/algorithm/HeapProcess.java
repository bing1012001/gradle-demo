package com.interview.algorithm;

/**
 * @author Bing ZHANG
 * @created 09/01/2022
 *           7
 *         /   \
 *        7     6
 *       /\    /\
 *      2 3   6 5
 *  big root binary tree, structure of heap
 */
public class HeapProcess {

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] < arr[(index-1) /2]) {
            swap(arr, index, (index-1)/2);
            index = (index -1) /2;
        }
    }

    public static void heapSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while(heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    //at index position, check whether the this value can be moved to child level to meet big root binary tree (heap)
    public static void heapify(int[] arr, int index, int heapSize) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        while(leftChild < heapSize) {
            int biggerValuePosition = rightChild < heapSize && arr[rightChild] > arr[leftChild] ? rightChild : leftChild;
            biggerValuePosition = arr[index] < arr[biggerValuePosition] ? biggerValuePosition : index;
            if(biggerValuePosition == index) {
                break;
            }
            swap(arr, index, biggerValuePosition);
            index = biggerValuePosition;
            leftChild = 2 * index + 1;
            rightChild = 2 * index + 2;
        }
    }
    public static void swap(int[] arr, int l, int r) {
        arr[l] = arr[l] ^ arr[r];
        arr[r] = arr[l] ^ arr[r];
        arr[l] = arr[l] ^ arr[r];
    }

}
