package com.interview.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Bing ZHANG
 * @created 11/01/2022
 */
public class BinaryTreeIterationRecursion {

    class Node {
        int value;
        Node left;
        Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void preOrderIterate(Node head) {
        if(head == null) {
            return;
        }
        System.out.println(head.value);
        preOrderIterate(head.left);
        preOrderIterate(head.right);
    }

    public static void preOrderIterateNoRecursion(Node head) {
        if(head != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while(!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.value);
                if(head.right != null) {
                    stack.push(head.right);
                }
                if(head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }

    public static void widthIterateNoRecursion(Node head) {
        if(head == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (! queue.isEmpty()) {
            head = queue.poll();
            System.out.println(head.value);
            if(head.left != null)
                queue.add(head.left);
            if(head.right != null)
                queue.add(head.right);

        }

    }
    public static void inOrderInterateNoRecursion(Node head) {
        if(head != null) {
            Stack<Node> stack = new Stack<>();
            while(!stack.isEmpty() || head != null) {
                if(head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.println(head.value);
                    head = head.right;
                }
            }
        }
    }
    public static void inOrderIterate(Node head) {
        if(head == null) {
            return;
        }
        inOrderIterate(head.left);
        System.out.println(head.value);
        inOrderIterate(head.right);
    }

    public static boolean checkSearchBinaryTree(Node head) {
        int preValue = Integer.MIN_VALUE;
        if(head == null) {
            return true;
        }
        boolean isleftQualified = checkSearchBinaryTree(head.left);
        if(!isleftQualified) return false;
        if(head.value <= preValue) {
            return false;
        } else {
            preValue = head.value;
        }
        return checkSearchBinaryTree(head.right);
    }

    public static void postOrderIterate(Node head) {
        if(head == null) {
            return;
        }
        postOrderIterate(head.left);
        postOrderIterate(head.right);
        System.out.println(head.value);
    }

    public static void main(String[] args) {

    }
}
