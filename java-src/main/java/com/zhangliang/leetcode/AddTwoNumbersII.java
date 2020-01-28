package com.zhangliang.leetcode;
/*
You are given two non-empty linked lists representing two non-negative integers. 
The most significant digit comes first and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:
Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
*/

import java.util.Stack;

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> l1Stack = new Stack<>();
        Stack<ListNode> l2Stack = new Stack<>();

        // push
        ListNode cur = l1;
        while (cur != null) {
            l1Stack.push(cur);
            cur = cur.next;
        }
        cur = l2;
        while (cur != null) {
            l2Stack.push(cur);
            cur = cur.next;
        }

        int step = 0;
        ListNode dummy = new ListNode(-1);
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty() || step != 0) {
            int val = step;
            if (!l1Stack.isEmpty()) {
                val += l1Stack.pop().val;
            }
            if (!l2Stack.isEmpty()) {
                val += l2Stack.pop().val;
            }
            ListNode node = new ListNode(val % 10);
            node.next = dummy.next;
            dummy.next = node;
            step = val / 10;
        }
        return dummy.next;
    }
}
