package com.interview.algorithm;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Bing ZHANG
 * @created 16/01/2022
 */
public class BinaryTreeSharedParentNodeCalc {

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node lowestCommonAncestor(Node head, Node n1, Node n2) {
        HashMap<Node, Node> fatherMap = new HashMap<>();
        fatherMap.put(head, head);
        process(head, fatherMap);
        HashSet<Node> set = new HashSet<>();
        Node cur1 = n1;
        while(cur1 != fatherMap.get(cur1)) {
            set.add(cur1);
            cur1 = fatherMap.get(cur1);
        }
        set.add(head);
        Node cur2 = n2;
        while(cur2 != fatherMap.get(cur2)) {
            if(set.contains(fatherMap.get(cur2)) ) {
                return fatherMap.get(cur2);
            } else {
                cur2 = fatherMap.get(cur2);
            }
        }
        return head;

    }

    public static void process(Node head, HashMap<Node,Node> fatherMap) {
        if(head == null) {
            return;
        }
        fatherMap.put(head.left, head);
        fatherMap.put(head.right, head);
        process(head.left, fatherMap);
        process(head.right, fatherMap);
    }

    public static void main(String[] args) {

    }

}
