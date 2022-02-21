package com.interview.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Bing ZHANG
 * @created 16/01/2022
 */
public class BinaryTreeSerialization {

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value ) {
            this.value = value;
        }
    }

    public static String serializeBT(Node head) {
        if(head == null) {
            return "#_";
        }
        String res = head.value + "_";
        res += serializeBT(head.left);
        res += serializeBT(head.right);
        return res;
    }

    public static Node deserializeBT(String res) {
        String[] arr = res.split("_");
        Queue<String> queue = new LinkedList<>();
        for(int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        return reconstruct(queue);
    }

    public static Node reconstruct(Queue<String> queue) {
        String str = queue.poll();
        if("#".equals(str)) {
            return null;
        }
        Node head = new Node(Integer.parseInt(str));
        head.left = reconstruct(queue);
        head.right = reconstruct(queue);
        return head;
    }
    public static void main(String[] args) {

    }

}
