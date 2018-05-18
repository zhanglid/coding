package com.zhangliang.leetcode;
/*
Given a linked list, swap every two adjacent nodes and return its head.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
Note:

Your algorithm should use only constant extra space.
You may not modify the values in the list's nodes, only nodes itself may be changed.
*/


public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode left = head;
        ListNode right = head.next;
        ListNode prev = dummy;

        while (right != null) {
            left.next = right.next;
            right.next = left;
            prev.next = right;
            prev = left;
            left = left.next;
            if (left == null) {
                break;
            }
            right = left.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        SwapNodesInPairs s = new SwapNodesInPairs();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode ans = s.swapPairs(head);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}