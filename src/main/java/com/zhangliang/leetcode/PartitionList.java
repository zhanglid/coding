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
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        ListNode prevCur = dummy;
        while (cur != null) {
            if (cur.val < x && cur != prev.next) {
                ListNode next = cur.next;
                prevCur.next = next;
                cur.next = prev.next;
                prev.next = cur;
                prev = prev.next;
                cur = next;
            } else {
                if (cur.val < x && cur == prev.next) {
                    prev = prev.next;
                }
                prevCur = cur;
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
