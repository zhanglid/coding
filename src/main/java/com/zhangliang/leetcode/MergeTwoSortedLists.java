package com.zhangliang.leetcode;
/*
Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes 
of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
*/

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            if (l2 == null || l1 != null && l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists s = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(new int[] { 1, 2, 4 });
        ListNode l2 = new ListNode(new int[] { 1, 3, 4 });
        System.out.println(s.mergeTwoLists(l1, l2).toString());
    }
}