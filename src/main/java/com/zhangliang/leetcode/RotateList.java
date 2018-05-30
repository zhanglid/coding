package com.zhangliang.leetcode;
/*
Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL

*/

public class RotateList {
    private int getListLength(ListNode head) {
        int ans = 0;
        while(head != null) {
            ans++;
            head = head.next;
        }

        return ans;
    }
    public ListNode rotateRight(ListNode head, int k) {
        int len = getListLength(head);
        if (len == 0 || k < 0) {
            return head;
        }

        int offset = k % len;

        ListNode r = head;
        ListNode l = head;
        int count = 0;
        while (r.next != null) {
            if (count >= offset) {
                l = l.next;
            }

            r = r.next;
            count++;
        }

        r.next = head;
        ListNode ans = l.next;
        l.next = null;
        return ans;
    }
}
