package com.zhangliang.leetcode;
/*
You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.

Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.

 

Example:

Input:
 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL

Output:
1-2-3-7-8-11-12-9-10-4-5-6-NULL
 

Explanation for the above example:

Given the following multilevel doubly linked list:

We should return the following flattened doubly linked list:
*/

public class FlattenAMultilevelDoublyLinkedList {
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }

        public Node(int[] vals) {
            this.val = vals[0];
            Node cur = this;
            for (int i = 1; i < vals.length; i++) {
                cur.next = new Node(vals[i]);
                cur = cur.next;
            }
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    private Node helper(Node head) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        Node prev = null;
        while (cur != null) {
            if (cur.child != null) {
                Node tail = helper(cur.child);
                tail.next = cur.next;
                if (tail.next != null) {
                    tail.next.prev = tail;
                }
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
                cur = tail;
            }
            prev = cur;
            cur = cur.next;
        }
        return prev;
    }

    public Node flatten(Node head) {
        helper(head);
        rerurn head;
    }
}
