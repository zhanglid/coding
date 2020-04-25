package com.zhangliang.leetcode;
/*
Sort a linked list using insertion sort.


A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element 
in the list.
With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 

Algorithm of Insertion Sort:

Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within 
the sorted list, and inserts it there.
It repeats until no input elements remain.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
*/

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode left = head;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            ListNode posCur = dummy;
            while (posCur != left && posCur.next.val < cur.next.val) {
                posCur = posCur.next;
            }

            if (posCur.next == cur.next) {
                left = cur.next;
                cur = cur.next;
            } else {
                ListNode next = posCur.next;
                ListNode nextCurNext = cur.next.next;
                posCur.next = cur.next;
                posCur.next.next = next;
                cur.next = nextCurNext;
            }
        }

        return dummy.next;
    }
}
