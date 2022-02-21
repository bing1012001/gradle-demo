package com.interview.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Bing ZHANG
 * @created 11/01/2022
 */
public class LinkedListQuestions {

    public static Node getLoopNode(Node head) {
       if(head == null) return null;
        Set<Node> set = new HashSet<>();
        while(head != null) {
            if(set.contains(head)) return head;
            set.add(head);
            head = head.next;
        }
        return null;
    }

    public static Node NodesHaveMerge(Node head1, Node head2) {
        if(head1 == null || head2 == null) {
            return null;
        }

        Node cur1 = head1;
        Node cur2 = head2;
        int n1 = 0;
        int n2 = 0;
        while(cur1 != null) {
            cur1 = cur1.next;
            n1++;
        }
        while(cur2 != null) {
            cur2 = cur2.next;
            n2++;
        }

        if(cur1 != cur2) return null; //no merge
        cur1 = n1 > n2 ? head1 : head2; // longer nodelist
        cur2 = cur1 == head1 ? head2 : head1; // shorter node list
        int n = Math.abs(n2 - n1);
        while(n != 0) {
            cur1= cur1.next;
            n--;
        }
        while(cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public static Node getLoopNode2(Node head) {
        if(head == null || head.next == null || head.next.next == null) {
            return null;
        }

        Node n1 = head.next;
        Node n2 = head.next.next;
        while(n1 != n2) {
            if(n2.next == null || n2.next.next == null) {
                return null;
            }
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = head;
        while(n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    class Node {
        int value;
        Node next;
    }

    public static void main(String[] args) {

    }
}
