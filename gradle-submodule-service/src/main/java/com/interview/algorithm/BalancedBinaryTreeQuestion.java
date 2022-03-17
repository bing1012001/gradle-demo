package com.interview.algorithm;

/**
 * @author Bing ZHANG
 * @created 13/01/2022
 */
public class BalancedBinaryTreeQuestion {


    public static class TreeHeightBalanceResult {
        int height;
        boolean isBalanced;

        public TreeHeightBalanceResult(int height, boolean isBalanced) {
            this.height = height;
            this. isBalanced = isBalanced;
        }
    }

    static class Node {
        int value;
        Node left;
        Node right;
    }
    public static TreeHeightBalanceResult balanceCheck(Node head) {
        if(head == null) return new TreeHeightBalanceResult(0, true);
        TreeHeightBalanceResult leftData = balanceCheck(head.left);
        TreeHeightBalanceResult rightData = balanceCheck(head.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced && Math.abs(leftData.height - rightData.height) < 2;
        return new TreeHeightBalanceResult(height, isBalanced);

    }

    public static void main(String[] args) {

    }

}
