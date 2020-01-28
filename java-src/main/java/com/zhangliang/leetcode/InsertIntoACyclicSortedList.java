package com.zhangliang.leetcode;
/*
Given a node from a cyclic linked list which is sorted in ascending order, write a function to insert a value into 
the list such that it remains a cyclic sorted list. The given node can be a reference to any single node in the list, 
and may not be necessarily the smallest value in the cyclic list.

If there are multiple suitable places for insertion, you may choose any place to insert the new value. After the 
insertion, the cyclic list should remain sorted.

If the list is empty (i.e., given node is null), you should create a new single cyclic list and return the reference 
to that single node. Otherwise, you should return the original given node.

The following example may help you understand the problem better:

1 - +
|   |
4 - 3 <-

In the figure above, there is a cyclic sorted list of three elements. You are given a reference to the node with value 
3, and we need to insert 2 into the list.

1 - 2
|   |
4 - 3 <-

The new node should insert between node 1 and node 3. After the insertion, the list should look like this, and we 
should still return node 3.
*/

public class InsertIntoACyclicSortedList {
    static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Node)) {
                return false;
            }
            Node node = (Node) obj;
            Node otherCur = node;
            Node cur = this;
            while (otherCur.next != node && cur.next != this) {
                if (otherCur.val != cur.val) {
                    return false;
                }
                otherCur = otherCur.next;
                cur = cur.next;
            }
            return otherCur.next == node && cur.next == this;
        }
    };

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node result = new Node();
            result.val = insertVal;
            result.next = result;
            return result;
        }

        Node cur = head;
        Node max = head;
        do {
            if (cur.next.val >= insertVal && cur.val <= insertVal) {
                cur.next = new Node(insertVal, cur.next);
                return head;
            }
            if (cur.next.val < cur.val) {
                max = cur;
            }
            cur = cur.next;
        } while (cur != head);

        max.next = new Node(insertVal, max.next);
        return head;
    }
}
