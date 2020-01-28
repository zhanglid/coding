package com.zhangliang.leetcode;
/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of 
nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.
*/

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode blockPrev = dummy;
        while (blockPrev.next != null) {
            ListNode cur = blockPrev;

            int count = 0;
            while (cur.next != null && count != k) {
                count++;
                cur = cur.next;
            }

            if (count < k) {
                break;
            }

            // reverse
            ListNode tail = cur;
            ListNode blockNext = tail.next;
            cur = blockPrev.next;
            ListNode blockPrevNext = cur;
            ListNode prev = blockNext;
            while (cur != blockNext) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }

            blockPrev.next = tail;
            blockPrev = blockPrevNext;
        }

        return dummy.next;
    }
}
