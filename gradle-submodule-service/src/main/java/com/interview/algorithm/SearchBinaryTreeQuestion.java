package com.interview.algorithm;

/**
 * @author Bing ZHANG
 * @created 14/01/2022
 */
public class SearchBinaryTreeQuestion {

    public static class ReturnType {
        boolean isSearchBinaryTree;
        int min;
        int max;
        public ReturnType(boolean isSearchBinaryTree, int min, int max) {
            this.isSearchBinaryTree = isSearchBinaryTree;
            this.min = min;
            this.max = max;
        }
    }

    class Node {
        int value;
        Node left;
        Node right;
    }

    public static ReturnType process(Node head) {
        if(head == null) return null;

        ReturnType leftReturn = process(head.left);
        ReturnType rightReturn = process(head.right);
        int min = head.value;
        int max = head.value;
        if(head.left != null) min = Math.min(min, leftReturn.min);
        if(head.right != null) max = Math.max(max, rightReturn.max);
        boolean isSearchBT = true;
        if(leftReturn != null && (!leftReturn.isSearchBinaryTree || leftReturn.max >= head.value)) isSearchBT = false;
        if(rightReturn != null && (!rightReturn.isSearchBinaryTree || rightReturn.min <= head.value )) isSearchBT = false;

        return new ReturnType(isSearchBT, min, max);
    }
    public static void main(String[] args) {

    }
}
