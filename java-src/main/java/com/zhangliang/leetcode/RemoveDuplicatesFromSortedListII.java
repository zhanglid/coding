package com.zhangliang.leetcode;
/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from 
the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3
*/

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null) {
            ListNode end = cur;
            while (end != null && end.val == cur.val) {
                end = end.next;
            }

            if (end == cur.next) {
                prev = cur;
                cur = cur.next;
            } else {
                prev.next = end;
                cur = end;
            }
        }

        return dummy.next;
    }
}
