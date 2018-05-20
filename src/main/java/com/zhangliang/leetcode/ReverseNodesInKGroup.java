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
        if (head == null || k < 1) {
            return head;
        }

        ListNode dummy = new ListNode(1);
        dummy.next = head;
        ListNode blockPrev = dummy;
        ListNode blockHead = head;
        ListNode prev = dummy;
        ListNode cur = head;
        int count = 0;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count++;
            if (count == k) {
                blockPrev.next = prev;
                blockPrev = blockHead;
                prev = null;
                blockHead = cur;
                count = 0;
            }
        }
        if (count != 0) {
            ListNode prev2 = null;
            while(prev != null) {
                ListNode next = prev.next;
                prev.next = prev2;
                prev2 = prev;
                prev = next;
            }
            blockPrev.next = prev2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup s = new ReverseNodesInKGroup();
        System.out.println(s.reverseKGroup());
    }
}
