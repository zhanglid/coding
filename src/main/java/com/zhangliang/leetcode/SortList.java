package com.zhangliang.leetcode;
/*
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
*/

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rightHalf = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rightHalf);

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (left != null || right != null) {
            if (left != null && (right == null || right.val > left.val)) {
                cur.next = new ListNode(left.val);
                left = left.next;
            } else {
                cur.next = new ListNode(right.val);
                right = right.next;
            }

            cur = cur.next;
        }

        return dummy.next;
    }
}
