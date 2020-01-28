package com.zhangliang.leetcode;
/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater 
than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
*/

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode left = dummy;
        ListNode curPrev = dummy;

        while (curPrev != null && curPrev.next != null) {
            if (curPrev.next.val < x) {
                if (curPrev.next == left.next) {
                    left = left.next;
                    curPrev = curPrev.next;
                } else {
                    ListNode node = curPrev.next;
                    curPrev.next = node.next;
                    node.next = left.next;
                    left.next = node;
                    left = left.next;
                }
            } else {
                curPrev = curPrev.next;
            }
        }

        return dummy.next;
    }
}
