package com.zhangliang.leetcode;
/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3
*/

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == cur.val) {
                ListNode rightCur = cur.next;
                while (rightCur.next != null && rightCur.next.val == cur.val) {
                    rightCur = rightCur.next;
                }
                cur.next = rightCur.next;
            }
            cur = cur.next;
        }

        return head;
    }
}
