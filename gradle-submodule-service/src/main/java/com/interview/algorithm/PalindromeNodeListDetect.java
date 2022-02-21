package com.interview.algorithm;

import java.util.Stack;

/**
 * @author Bing ZHANG
 * @created 10/01/2022
 * 1->2->3->2->1
 */
public class PalindromeNodeListDetect {

    class Node {
        int value;
        Node next;
    }

    public static boolean detectWithStack(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while(cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        while(head != null) {
            if(head.value != stack.pop().value) return false;
            head = head.next;
        }
        return true;
    }

    public static boolean detectWith2Pointers(Node head) {
        if(head == null || head.next == null) return true;
        Node p1 = head;
        Node p2 = head;
        while(p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        p2 = p1.next;
        p1.next = null;
        Node p3 = null;
        while(p2 != null) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        p3 = p1;
        p2 = head;
        boolean res= true;
        while(p1 != null && p2 != null) {
            if(p1.value != p2.value) {
                res = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
    return res;
    }
}
