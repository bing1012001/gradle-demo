package com.interview.algorithm;

import java.util.PriorityQueue;

/**
 * @author Bing ZHANG
 * @created 09/01/2022
 */
public class PriorityQueueSort {

    public static void sortArrDistanceLessThanK(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue();
        int index = 0;
        for(; index <= Math.min(arr.length, k);index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        for(; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while(!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }

    public static PriorityQueue<Integer> bigRootHeapGen() {
        return new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
    }
    public static void main(String[] args) {

    }
}
