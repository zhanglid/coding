package com.zhangliang.leetcode;
/*
A linked list is given such that each node contains an additional random pointer which could point to 
any node in the list or null.

Return a deep copy of the list.
*/

import com.zhangliang.utils.RandomListNode;

public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }

        // make a clone node
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode next = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.random = cur.random;
            cur.next.next = next;
            cur = next;
        }

        // change random pointer to its clone
        cur = head;
        while (cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }

        // distint cloned linkedList and old one
        RandomListNode ans = head.next;
        cur = head;
        while (cur != null) {
            RandomListNode clonedNode = cur.next;
            cur.next = clonedNode.next;
            clonedNode.next = cur.next == null ? null : cur.next.next;
            cur = cur.next;
        }

        return ans;
    }
}
