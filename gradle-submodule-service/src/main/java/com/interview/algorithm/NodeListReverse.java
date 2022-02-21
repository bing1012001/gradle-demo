package com.interview.algorithm;

import java.util.*;

/**
 * @author Bing ZHANG
 * @created 10/01/2022
 */
public class NodeListReverse {
    class Node{
        int value;
        Node next;
    }



    public static Node reverse(Node head) {
        Node next = null;
        Node pre = null;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
