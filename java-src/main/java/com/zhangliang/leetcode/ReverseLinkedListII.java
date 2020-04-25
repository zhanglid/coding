package com.zhangliang.leetcode;
/*
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL

*/

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m >= n) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode lprev = dummy;
        ListNode rcur = dummy;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            if (count == m - 2) {
                lprev = cur;
            }

            if (count == n - 1) {
                rcur = cur;
                break;
            }

            cur = cur.next;
            count++;
        }

        if (rcur == dummy) {
            return head;
        }
        cur = lprev.next.next;
        ListNode prev = lprev.next;
        ListNode blockNext = rcur.next;
        while (cur != blockNext) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        lprev.next.next = blockNext;
        lprev.next = rcur;

        return dummy.next;
    }
}
